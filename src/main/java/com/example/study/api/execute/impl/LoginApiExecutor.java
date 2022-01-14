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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LoginApiExecutor extends ApiGetter {

    //    @Value("${api.url.login}")
//    private String url;

    public LoginApiExecutor(RestTemplate connection, Map<String, Object> bodyMap,
        LoginStatus status) {
        super(connection, bodyMap);

    }

    @Override
    public ApiExecutor put(Map<String, String> param) {
        bodyMap.putAll(param);
        return this;
    }

    @Override
    public ApiExecutor send() {
        HttpEntity<Login> entity = set(bodyMap,
            "95fca38ba5c78be7f3ed0c1a1bf3e657f5bcc27b76dcf7664fabcb146a2f18508");

        String url = "http://api.koreannet.or.kr/mobileweb/stdprd/loginAction.do";

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
            .encode(StandardCharsets.UTF_8)
            .build();

        status = connection.exchange(uri.toString(), HttpMethod.POST,
            entity, LoginStatus.class).getBody();

        return this;
    }

    @Override
    public LoginStatus getResult() {
        return status;
    }

    private HttpEntity<Login> set(Map<String, Object> bodyMap, String appKey) {
        Login user = Login.builder()
            .id(String.valueOf(bodyMap.get("id")))
            .password(String.valueOf(bodyMap.get("pw")))
            .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("appKey", appKey);

        return new HttpEntity<>(user, headers);
    }
}
