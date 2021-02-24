package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{
}
