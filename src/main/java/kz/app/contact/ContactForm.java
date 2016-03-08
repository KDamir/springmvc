package kz.app.contact;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by kdamir on 3/7/16.
 */
public class ContactForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = ContactForm.NOT_BLANK_MESSAGE)
    private String userName;

    @NotBlank(message = ContactForm.NOT_BLANK_MESSAGE)
    @Email(message = ContactForm.EMAIL_MESSAGE)
    private String userEmail;

    @NotBlank(message = ContactForm.NOT_BLANK_MESSAGE)
    private String message;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
