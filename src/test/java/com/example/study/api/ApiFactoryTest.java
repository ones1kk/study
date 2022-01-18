package com.example.study.api;

import static org.junit.jupiter.api.Assertions.*;

import com.example.study.api.model.Login;
import com.example.study.api.model.LoginStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
@SpringBootTest
class ApiFactoryTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void restTemplate() {
        Login login =  Login.builder().id("kcci005").password("wonsik2089").build();
        LoginStatus status = restTemplate.postForObject(
            "http://api.koreannet.or.kr/mobileweb/stdprd/loginAction.do", login,
            LoginStatus.class);

        System.out.println("status = " + status);
    }

}