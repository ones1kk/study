package com.example.study.api.execute.impl;

import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.LoginStatus;
import com.google.gson.JsonObject;
import java.net.HttpURLConnection;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginApiExecutor extends ApiGetter {

    @Value("${api.url.login}")
    private String url;

    public LoginApiExecutor(HttpURLConnection connection, JsonObject json,
        Map<String, Object> param) {
        super(connection, json, param);
    }

    @Override
    public ApiExecutor write(Map<String, Object> param) {
        param.forEach((s, o) -> System.out.println(s + " : " + o));
        System.out.println("url = " + url);
        return null;
    }

    @Override
    public LoginStatus send() {
        return null;
    }
}
