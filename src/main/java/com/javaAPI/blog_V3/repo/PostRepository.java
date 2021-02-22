package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long>{
    List<Post> findAll();
}
