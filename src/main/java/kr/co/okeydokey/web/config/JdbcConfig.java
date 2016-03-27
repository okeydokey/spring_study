package kr.co.okeydokey.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Driver;

/**
 * @author okeydokey
 */
@Configuration
@EnableJpaRepositories("kr.co.okeydokey.web.security")
@PropertySource("classpath:config.properties")
public class JdbcConfig {
    @Value("${db.driverClass}") Class<? extends Driver> driverClass;
    @Value("${db.url}") String url;
    @Value("${db.username}")  String username;
    @Value("${db.password}") String password;

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource ds = new SimpleDriverDataSource();

        ds.setDriverClass(this.driverClass);
        ds.setUrl(this.url);
        ds.setUsername(this.username);
        ds.setPassword(this.password);

        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("kr.co.okeydokey.web.security");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
