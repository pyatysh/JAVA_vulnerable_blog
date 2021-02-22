package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // List <User> findByUserName(String username);
    // User findById(long id);
}