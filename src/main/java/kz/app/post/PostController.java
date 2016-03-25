package kz.app.post;

import kz.app.account.Account;
import kz.app.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by kdamir on 3/7/16.
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
    public String post(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);

        model.addAttribute("post",post);
        return "posts/show";
    }

    @RequestMapping(value = "newpost", method = RequestMethod.GET)
    public String newpost(Model model) {
        model.addAttribute(new PostForm());
        return "posts/newpost";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Principal principal, @Valid @ModelAttribute PostForm postForm) {
        Account account = accountService.getAccountByUserName(principal.getName());

        if(account == null)
            throw new IllegalArgumentException("user name is null");

        Post post = postForm.createPost(account);

        postService.save(post);

        return "redirect:/";
    }
}
