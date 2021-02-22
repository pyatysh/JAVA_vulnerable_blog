package com.javaAPI.blog_V3.models;

import javax.persistence.*;
import java.util.Set;
// import java.util.Date;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String userName, password, email;

//    private Date createdAt;

    //    @OneToMany(mappedBy="user")
    //    private Set<Post> post;

//    @PrePersist
//    void createdAt() {
//        this.createdAt = new Date();
//    }

    public Long getId() {
        return user_id;
    }

    public void setId(Long id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public static enum Type {
//        ADMIN, USER
//    }
}