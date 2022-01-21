package com.example.study.refactor;

import com.example.study.refactor.model.ApiProperty;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class EntitySetterV2 extends InversionSetter {

    public EntitySetterV2(ApiProperty apiProperty, ApiSender sender) {
        super(apiProperty, sender);
    }

    public EntitySetterV2 get(Map<String, String> param, String url) {
        this.body = param;
        this.url = url;
        return this;
    }

    public ApiSender send() {
        HttpEntity<JSONObject> entity = setBody(body);
        UriComponents uri = setUri(url);

        return sender.send(uri, entity);
    }

    private HttpEntity<JSONObject> setBody(Map<String, String> bodyMap) {
        HttpHeaders headers = setHeaders(apiProperty.getAppKey());

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(bodyMap);

        return new HttpEntity<>(jsonObject, headers);
    }

    public UriComponents setUri(String url) {
        return UriComponentsBuilder.fromHttpUrl(url).encode(StandardCharsets.UTF_8).build();
    }

}
