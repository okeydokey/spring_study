package kr.co.okeydokey.web.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author okeydokey
 */
@AllArgsConstructor
@Data
@Entity
//TODO Table Name users
public class User {

    @Id
    private long id;
    private String username;
    private String password;
    private Boolean enabled;
}
