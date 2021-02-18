package com.javaAPI.blog_V3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "The main page"); // ("title" (var) will be transferred into the template;
                                                            // "The main page" (value of the var) instead of parameter, received in home meth.)
        return "home"; // open HTML template
    }

}
