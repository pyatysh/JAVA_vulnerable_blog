package com.javaAPI.blog_V3.service;

import com.javaAPI.blog_V3.repo.UserRepository;
import com.javaAPI.blog_V3.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> userFindAll() {
        return userRepository.findAll();
    }

    public User userSave(User user){
        return userRepository.save(user);
    }

    public Optional<User> userFind(long userId){
        return userRepository.findById(userId);
    }

    public void userDelete(User user) {
        userRepository.delete(user);
    }

}
