package kz.app.post;

import kz.app.account.Account;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Дамир on 24.03.2016.
 */
public class PostForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String header;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String text;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post createPost(Account account) {
        return new Post(getHeader(), account, getText());
    }
}
