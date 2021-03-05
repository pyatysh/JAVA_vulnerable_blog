package com.javaAPI.blog_V3.service;

import com.javaAPI.blog_V3.models.Comment;
import com.javaAPI.blog_V3.models.Post;
import com.javaAPI.blog_V3.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment blogComSave(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> blogComFind(long id){
        return commentRepository.findById(id);
    }

}
