package kz.app.home;

import kz.app.account.AccountService;
import kz.app.contact.ContactForm;
import kz.app.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "home/homeSignedIn" : "home/index";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
        model.addAttribute(new ContactForm());
		return "home/contact";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "home/about";
	}

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String viewPost() {
        return "home/post";
    }


}
