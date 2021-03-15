package com.javaAPI.blog_V3.service;

import com.javaAPI.blog_V3.userManagement.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    // check, if user from DAO exists and send it to controller

    @Autowired
    private UserDAO userDAO;

    public boolean userSearch(String username, String password){
        if (!userDAO.unsafeFindUserByUsername(username, password).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

