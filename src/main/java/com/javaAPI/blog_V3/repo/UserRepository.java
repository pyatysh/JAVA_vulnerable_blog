package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.Post;
import com.javaAPI.blog_V3.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName);
}
