package com.example.study.refactor;

import com.example.study.refactor.model.ResultStatus;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Component
@RequiredArgsConstructor
public class ApiSender {

    private final RestTemplate restTemplate;

    private ResultStatus status;

    public ApiSender send(UriComponents uri, HttpEntity<JSONObject> entity) {
        status = restTemplate.exchange(uri.toString(), HttpMethod.POST, entity, ResultStatus.class)
            .getBody();
        return this;
    }

    public ResultStatus getStatus() {
        return status;
    }

}
