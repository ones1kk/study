package com.example.study.api.execute.impl;

import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.Login;
import com.example.study.api.model.LoginStatus;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LoginApiExecutor extends ApiGetter {

    //    @Value("${api.url.login}")
//    private String url;

    public LoginApiExecutor(RestTemplate connection, Map<String, Object> queryParam) {
        super(connection, queryParam);
    }

    @Override
    public ApiExecutor put(Map<String, String> param) {
        queryParam.putAll(param);
        return this;
    }

    @Override
    public ResponseEntity<LoginStatus> send(String url) {
        System.out.println("LoginApiExecutor.send");
        queryParam.forEach((s, o) -> System.out.println(s + " : " + o));
        HttpHeaders header = new HttpHeaders();
        header.set("appKey", "95fca38ba5c78be7f3ed0c1a1bf3e657f5bcc27b76dcf7664fabcb146a2f18508");

        Login user = Login.builder()
            .id(String.valueOf(queryParam.get("id")))
            .password(String.valueOf(queryParam.get("pw")))
            .build();

        HttpEntity<Login> entity = new HttpEntity<>(user, header);

        System.out.println("entity = " + entity);

        url = "http://api.koreannet.or.kr/mobileweb/stdprd/loginAction.do";
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
            .encode(StandardCharsets.UTF_8)
            .build();



        return connection.exchange(uri.toString(), HttpMethod.POST,
            entity, LoginStatus.class);
    }
}
