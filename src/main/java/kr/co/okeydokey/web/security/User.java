package kr.co.okeydokey.web.security;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author okeydokey
 */
@Data
@Table(name="users")
public class User {
    String username;
    String password;
    Boolean enabled;
}
