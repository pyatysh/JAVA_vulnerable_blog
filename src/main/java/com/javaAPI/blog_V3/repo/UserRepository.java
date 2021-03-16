package com.javaAPI.blog_V3.repo;

import com.javaAPI.blog_V3.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
