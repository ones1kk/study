package com.example.study.refactor;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class EntitySetterV2 {

    private final Map<String, String> bodyMap;

    private final String url;

    public ApiSender send() {
        HttpEntity<JSONObject> entity = setBody(bodyMap);
        UriComponents uri = setUri(url);

        return new ApiSender(new RestTemplate(), uri, entity);
    }

    public HttpEntity<JSONObject> setBody(Map<String, String> bodyMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("appKey",
            "95fca38ba5c78be7f3ed0c1a1bf3e657f5bcc27b76dcf7664fabcb146a2f1850805be5a47bbf0062404f8040e26a141cbe6d5ca64ea96104aef65a81341b0b2a");
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(bodyMap);

        return new HttpEntity<>(jsonObject, headers);
    }

    public UriComponents setUri(String url) {
        return UriComponentsBuilder.fromHttpUrl(url)
            .encode(StandardCharsets.UTF_8)
            .build();
    }


}
