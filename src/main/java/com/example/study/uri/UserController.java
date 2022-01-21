package com.example.study.uri;

import com.example.study.uri.annotation.MySecured;
import com.example.study.uri.model.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @GetMapping("/login")
    @ResponseBody
    public String set(HttpServletRequest request, String id){
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        return "set session";
    }

//    @MySecured(role = Role.USER)
    @GetMapping("/move")
    public String move(){
        return "redirect:/run";
    }

//    @MySecured(role= Role.USER)
    @GetMapping("/run")
    @ResponseBody
    public String run(){
        return "run";
    }

}
