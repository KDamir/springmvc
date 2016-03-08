package kz.app.post;

import kz.app.account.Account;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kdamir on 3/7/16.
 */

@Entity
@Table(name = "mypost")
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Type(type = "text")
    private String namePost;

    @ManyToOne
    private Account account;

    @Type(type = "text")
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
