package com.example.study.api.execute.impl;

import com.example.study.api.EntitySetter;
import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.ApiProperty;
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
        ApiProperty apiProperty, EntitySetter setter) {
        super(connection, bodyMap, apiProperty, setter);

    }

    @Override
    public ApiExecutor put(Map<String, String> param) {
        bodyMap.putAll(param);
        return this;
    }

    @Override
    public ApiExecutor send() {
        HttpEntity<Login> entity = setter.set(bodyMap,
            apiProperty.getAppKey());

        String url = apiProperty.getUrl().getLogin();

        UriComponents uri = setter.setUri(url);

        status = connection.exchange(uri.toString(), HttpMethod.POST,
            entity, LoginStatus.class).getBody();

        return this;
    }

}
