package com.javaAPI.blog_V3.controllers;

import com.javaAPI.blog_V3.models.Post;
import com.javaAPI.blog_V3.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    // we need to transfer all notes into the template
    @Autowired // thus, we need to create a var, which will link us with the repo
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
}
