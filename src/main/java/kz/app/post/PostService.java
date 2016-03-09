package kz.app.post;

import kz.app.account.Account;
import kz.app.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by kdamir on 3/7/16.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AccountService accountService;

    @PostConstruct
    protected void initilize() {
        Account demo = accountService.getAccountByUserName("user");

        if(demo == null)
            return;

        Post post = new Post("Some name post", demo, "Bla bla bla");
        save(post);
        //demo.getPosts().add(post);
        //accountService.save(demo);
    }

    @Transactional
    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public Post getPost(Long postId) {
        Post post = postRepository.findOne(postId);
        Account demo = accountService.getAccountByUserName("user");

        if(post == null) {
            Post newPost = new Post();
            newPost.setNamePost("Name Post");
            newPost.setAccount(demo);
            newPost.setText("Some Text");
            return save(newPost);
        }

        return post;
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }



}
