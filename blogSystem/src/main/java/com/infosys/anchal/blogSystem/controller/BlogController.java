package com.infosys.anchal.blogSystem.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.anchal.blogSystem.model.BlogPost;
import com.infosys.anchal.blogSystem.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping("/posts")
    public List<BlogPost> getAllBlogPosts() {
        return blogService.getAllBlogPosts();
    }
    
    @PostMapping("/create")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogService.createBlogPost(blogPost);
    }
    
    @GetMapping("/search")
    public List<BlogPost> findBlogPostsByTitle(@RequestParam String title) {
        return blogService.findBlogPostsByTitle(title);
    }	
}
