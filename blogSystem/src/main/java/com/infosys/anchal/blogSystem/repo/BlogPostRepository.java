package com.infosys.anchal.blogSystem.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.anchal.blogSystem.model.BlogPost;
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
	List<BlogPost> findByTitle(String title);
}
