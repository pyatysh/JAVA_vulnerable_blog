package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
    List<Post> findByTitleContainingIgnoreCase(String searchWords);
}
