package com.javaAPI.blog_V3.controllers;

import com.javaAPI.blog_V3.models.Comment;
import com.javaAPI.blog_V3.models.Post;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Struct;
import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page"); // ("title" (var) will be transferred into the template;
                                                            // "The main page" (value of the var) instead of parameter, received in home meth.)
        return "home"; // open HTML template home.html
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "about";
    }

}
