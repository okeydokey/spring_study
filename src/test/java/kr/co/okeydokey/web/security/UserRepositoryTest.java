package kr.co.okeydokey.web.security;

import kr.co.okeydokey.web.config.JdbcConfig;
import kr.co.okeydokey.web.config.MvcConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author okeydokey
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JdbcConfig.class})
@WebAppConfiguration
@Transactional
@Rollback
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setUsername("okeydokey");
    }

    @Test
    public void testCreateUser() {
        User createUser = userRepository.save(user);
        Assert.assertEquals(createUser.getUsername(), user.getUsername());
    }

    @Test
    public void testFindByUsername() throws Exception {
        userRepository.save(user);

        List<User> createUser = userRepository.findByUsername(user.getUsername());
        Assert.assertEquals(createUser.get(0).getUsername(), user.getUsername());
    }

    @Test
    public void deleteAll(){
        userRepository.save(new User("user1"));
        userRepository.save(new User("uesr2"));
        userRepository.save(new User("user3"));

        userRepository.deleteAll();

        Assert.assertEquals(userRepository.count(), 0);
    }

}