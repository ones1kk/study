package com.example.study.uri;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UriController {

    @GetMapping("/move")
    public String move(){
        return "move";
    }

    @GetMapping("/run")
    public String run(){
        return "run";
    }

}
