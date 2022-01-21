package com.example.study.uri;

import com.example.study.uri.annotation.MySecured;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/login")
    public String set(HttpServletRequest request, String id){
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        return "set session";
    }

    @MySecured
    @GetMapping("/move")
    public String move(){
        return "move";
    }

    @GetMapping("/run")
    public String run(){
        return "run";
    }

}
