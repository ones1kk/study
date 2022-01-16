package com.example.study.api.execute.impl;

import com.example.study.api.EntitySetter;
import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.Login;
import com.example.study.api.model.LoginStatus;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Component
public class LoginApiExecutor extends ApiGetter {

    public LoginApiExecutor(RestTemplate connection, Map<String, Object> bodyMap,
        EntitySetter setter) {
        super(connection, bodyMap, setter);

    }

    @Override
    public ApiExecutor put(Map<String, String> param) {
        bodyMap.putAll(param);
        return this;
    }

    @Override
    public ApiExecutor send() {
        HttpEntity<Login> entity = setter.set(bodyMap,
            "95fca38ba5c78be7f3ed0c1a1bf3e657f5bcc27b76dcf7664fabcb146a2f18508");

        String url = "http://api.koreannet.or.kr/mobileweb/stdprd/loginAction.do";

        UriComponents uri = setter.setUri(url);

        status = connection.exchange(uri.toString(), HttpMethod.POST,
            entity, LoginStatus.class).getBody();

        return this;
    }

    @Override
    public LoginStatus getResult() {
        return status;
    }

}
