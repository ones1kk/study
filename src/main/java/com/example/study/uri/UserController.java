package com.example.study.uri;

import com.example.study.uri.annotation.MySecured;
import com.example.study.uri.model.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, String email) {
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        return "login";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request, String id) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "logout";
    }

    @GetMapping("/move")
    public String move() {
        System.out.println("UserController.move");
        return "forward:/run";
    }

    @GetMapping("/fly")
    @ResponseBody
    public String fly() {
        return "fly";
    }

    @MySecured(role = Role.USER)
    @GetMapping("/run")
    @ResponseBody
    public String run() {
        System.out.println("UserController.run");
        return "run";
    }

    @MySecured(role = Role.USER)
    @GetMapping("/walk")
    @ResponseBody
    public String walk() {
        return "walk";
    }

}
