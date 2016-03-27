package kr.co.okeydokey.web.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author okeydokey
 */
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByUsername(String username);
}
