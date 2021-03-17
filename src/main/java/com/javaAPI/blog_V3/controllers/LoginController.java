package com.javaAPI.blog_V3.controllers;

import com.javaAPI.blog_V3.service.LoginService;
import com.javaAPI.blog_V3.service.UserService;
import com.javaAPI.blog_V3.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("title", "About");
        return "blog-login";
    }

    @PostMapping("/login")
    public void login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam String username,
                        @RequestParam String password,
                        Model model) throws ServletException, IOException {

        if (loginService.userSearch(username, password)){
            HttpSession oldSession = request.getSession(false);

            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("user", request.getParameter("username"));

//            Cookie message = new Cookie("message", "Welcome");
//            response.addCookie(message);

            response.sendRedirect("blog");
        }
        else {
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/blog-login");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("title", "About");
        return "blog-register";
    }

    @PostMapping("/registration")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           Model model){
        ArrayList<User> users = new ArrayList<>();
        User user = new User(username, password);
        userService.userSave(user);

        return "redirect:/login";
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null) {
            try {
                session.removeAttribute("user");
                session.invalidate();
                String pageToForward = request.getContextPath();
                response.sendRedirect(pageToForward);
            } catch (Exception sqle) {
                System.out.println("error UserValidateServlet message : " + sqle.getMessage());
                System.out.println("error UserValidateServlet exception : " + sqle);
            }
        }
    }


//    public String logout(HttpServletRequest request) {
//        System.out.println("You logged out");
//        HttpSession httpSession = request.getSession();
//        httpSession.invalidate();
//        return "redirect:/login";
//    }
}
