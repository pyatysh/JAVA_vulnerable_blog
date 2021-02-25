package com.javaAPI.blog_V3.models;

import javax.persistence.*;
import java.util.List;

@Entity // table creation
public class Post { // need to create fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String anons;
    private String fullTextPost;
    private int views;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Post() {
    }

    public Post(String title, String anons, String fullTextPost) {
        this.title = title;
        this.anons = anons;
        this.fullTextPost = fullTextPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullTextPost() {
        return fullTextPost;
    }

    public void setFullTextPost(String fullTextPost) {
        this.fullTextPost = fullTextPost;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
