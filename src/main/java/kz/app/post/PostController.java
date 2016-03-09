package kz.app.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kdamir on 3/7/16.
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
    public String post(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);

        model.addAttribute("post",post);
        return "posts/show";
    }
}
