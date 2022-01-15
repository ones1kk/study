package com.example.study.api;

import com.example.study.api.model.Login;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class EntitySetter {

    private HttpEntity<Login> entity;

    // @Value("${api.login.appKey}")
    // private String appKey;
    // @Value("${api.url.login}")
    // private String url;

    public HttpEntity<Login> set(Map<String, Object> bodyMap, String appKey) {
        Login user = Login.builder()
            .id(String.valueOf(bodyMap.get("id")))
            .password(String.valueOf(bodyMap.get("pw")))
            .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("appKey", appKey);

        entity = new HttpEntity<>(user, headers);

        return entity;
    }

    public UriComponents setUri(String url) {
        return UriComponentsBuilder.fromHttpUrl(url)
            .encode(StandardCharsets.UTF_8)
            .build();
    }

}
