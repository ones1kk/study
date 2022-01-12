package com.example.study.api.execute.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApiExecutorTest {

    @Value("${api.url.login}")
    private String url;

    @Test
    void getValue(){
        System.out.println("url = " + url);
    }

}