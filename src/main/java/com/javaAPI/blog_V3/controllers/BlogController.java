package com.javaAPI.blog_V3.controllers;

import com.javaAPI.blog_V3.models.Comment;
import com.javaAPI.blog_V3.models.Post;
import com.javaAPI.blog_V3.service.BlogService;
import com.javaAPI.blog_V3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

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
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String fullTextPost, Model model){
        ArrayList<Comment> comments = new ArrayList<>();
        Post post = new Post(title, anons, fullTextPost, comments);
        blogService.blogPostSave(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogPostDetails(@PathVariable(value = "id") long id, Model model){
        Optional<Post> postContainer = blogService.blogPostFind(id);
        if(postContainer.isEmpty()){
            return "redirect:/blog";
        }
        Post post = postContainer.get();
        model.addAttribute("post", post);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogPostEdit(@PathVariable(value = "id") long id, Model model){
        Optional<Post> postContainer = blogService.blogPostFind(id);
        if(postContainer.isEmpty()){
            return "redirect:/blog";
        }
        Post post = postContainer.get();
        model.addAttribute("post", post);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String fullTextPost, Model model){
        Post post = blogService.blogPostFind(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullTextPost(fullTextPost);
        blogService.blogPostSave(post);

        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = blogService.blogPostFind(id).orElseThrow();
        blogService.blogPostDelete(post);
        return "redirect:/blog";
    }

    @PostMapping("blog/{postId}/comments")
    public String blogPostAddCom(@PathVariable(value = "postId") long postId, @RequestBody String fullTextCom, Model model){
        Comment comment = new Comment();
        comment.setFullTextCom(fullTextCom);
        commentService.blogComSave(comment);
        Optional<Post> postContainer = blogService.blogPostFind(postId);
        if(postContainer.isEmpty()){
            return "blog-details";
        }
        Post post = postContainer.get();
        List<Comment> blogComments = post.getComments();
        blogComments.add(comment);
        blogService.blogPostSave(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{postId}/comments")
    public String blogShowCom(@PathVariable(value = "postId") long postId, Model model){
        Optional<Post> postContainer = blogService.blogPostFind(postId);
        if(postContainer.isEmpty()){
            return "blog-details";
        }
        List<Comment> blogComments = postContainer.get().getComments();
        model.addAttribute("comments", blogComments);
        return "redirect:/blog";
    }

}
