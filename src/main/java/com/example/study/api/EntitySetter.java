package com.example.study.api;

import com.example.study.api.model.Login;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class EntitySetter {

    private final JSONObject jsonObject;

    public HttpEntity<JSONObject> set(Map<String, String> bodyMap, String appKey) {
        Login user = Login.builder()
            .id(String.valueOf(bodyMap.get("id")))
            .password(String.valueOf(bodyMap.get("pw")))
            .gtin(String.valueOf(bodyMap.get("gtin")))
            .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("appKey", appKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        jsonObject.putAll(bodyMap);

        return new HttpEntity<>(jsonObject, headers);
    }

    public UriComponents setUri(String url) {
        return UriComponentsBuilder.fromHttpUrl(url)
            .encode(StandardCharsets.UTF_8)
            .build();
    }

}
