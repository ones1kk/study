package com.example.study.api.execute.impl;

import com.example.study.api.EntitySetter;
import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.LoginStatus;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Component
public class LoginApiExecutor extends ApiGetter {

    //    @Value("${api.url.login}")
//    private String url;
//
//    @Value("${api.appKey}")
//    private String appKey;
    private static final String appKey = "95fca38ba5c78be7f3ed0c1a1bf3e657f5bcc27b76dcf7664fabcb146a2f1850805be5a47bbf0062404f8040e26a141cbe6d5ca64ea96104aef65a81341b0b2a";

    public LoginApiExecutor(RestTemplate connection, Map<String, String> bodyMap,
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
        HttpEntity<JSONObject> entity = setter.set(bodyMap,
            appKey);
//            apiProperty.getAppKey());

        String url = "http://api.koreannet.or.kr/mobileweb/stdprd/loginAction.do";

        UriComponents uri = setter.setUri(url);

        status = connection.exchange(uri.toString(), HttpMethod.POST,
            entity, LoginStatus.class).getBody();

        return this;
    }

}
