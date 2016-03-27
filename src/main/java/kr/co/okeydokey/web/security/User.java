package kr.co.okeydokey.web.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author okeydokey
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//TODO Table Name users
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private Boolean enabled;


    public User(String username){
        this.username = username;
    }
}
