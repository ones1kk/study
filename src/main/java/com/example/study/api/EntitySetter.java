package com.example.study.api;

import com.example.study.api.model.Login;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class EntitySetter {

    public HttpEntity<Login> set(Map<String, Object> bodyMap, String appKey) {
        Login user = Login.builder()
            .id(String.valueOf(bodyMap.get("id")))
            .password(String.valueOf(bodyMap.get("pw")))
            .gtin(String.valueOf(bodyMap.get("gtin")))
            .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("appKey", appKey);

        return new HttpEntity<>(user, headers);
    }

    public UriComponents setUri(String url) {
        return UriComponentsBuilder.fromHttpUrl(url)
            .encode(StandardCharsets.UTF_8)
            .build();
    }

}
