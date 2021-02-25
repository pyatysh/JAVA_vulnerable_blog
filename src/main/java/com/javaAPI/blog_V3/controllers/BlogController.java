package com.javaAPI.blog_V3.controllers;

import com.javaAPI.blog_V3.models.Post;
import com.javaAPI.blog_V3.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = blogService.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        blogService.blogPostSave(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogPostDetails(@PathVariable(value = "id") long id, Model model){
        if(blogService.blogPostFind(id).isEmpty()){
            return "redirect:/blog";
        }
        Optional<Post> post = blogService.blogPostFind(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogPostEdit(@PathVariable(value = "id") long id, Model model){
        if(blogService.blogPostFind(id).isEmpty()){
            return "redirect:/blog";
        }
        Optional<Post> post = blogService.blogPostFind(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = blogService.blogPostFind(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        blogService.blogPostSave(post);

        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = blogService.blogPostFind(id).orElseThrow();
        blogService.blogPostDelete(post);
        return "redirect:/blog";
    }
}
