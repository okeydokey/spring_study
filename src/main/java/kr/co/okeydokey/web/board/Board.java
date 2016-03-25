package kr.co.okeydokey.web.board;

import kr.co.okeydokey.web.security.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author okeydokey
 */
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String contents;
    private User createUser;
    private Date createDate;
    private Date updateDate;
}
