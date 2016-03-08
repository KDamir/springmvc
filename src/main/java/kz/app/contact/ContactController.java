package kz.app.contact;

import kz.app.support.web.MessageHelper;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by kdamir on 3/7/16.
 */
public class ContactController {

    private static final String SIGNUP_VIEW_NAME = "contact/contact";

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public String sendMessage(@Valid @ModelAttribute ContactForm contactForm, Errors errors, RedirectAttributes ra) {

        if(errors.hasErrors())
            return SIGNUP_VIEW_NAME;

        MessageHelper.addSuccessAttribute(ra, "success");
        return "redirect:/";
    }

}
