package kr.co.okeydokey.web.board;

import kr.co.okeydokey.web.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author okeydokey
 */
@AllArgsConstructor
@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //TODO Not Null
    private String title;
    private String contents;

    //TODO Default 0
    private int viewCount;
    private User createUser;
    private User updateUser;

    //TODO Default now
    private Date createDate;
    //TODO Default now
    private Date updateDate;
}
