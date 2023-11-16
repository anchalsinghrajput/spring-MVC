package com.infosys.anchal.blogSystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.anchal.blogSystem.model.BlogPost;
import com.infosys.anchal.blogSystem.repo.BlogPostRepository;

@Service
public class BlogService {
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	 public List<BlogPost> getAllBlogPosts() {
	        return blogPostRepository.findAll();
	    }
	    
	    public BlogPost createBlogPost(BlogPost blogPost) {
	        return blogPostRepository.save(blogPost);
	    }
	    
	    public List<BlogPost> findBlogPostsByTitle(String title) {
	        return blogPostRepository.findByTitle(title);
	    }
}

