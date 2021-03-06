package com.example.study.api.execute.impl;

import com.example.study.api.EntitySetter;
import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class ProductAuthorityApiExecutor extends ApiGetter {

    public ProductAuthorityApiExecutor(RestTemplate connection,
        Map<String, String> bodyMap, EntitySetter setter) {
        super(connection, bodyMap, setter);
    }

    @Override
    public ApiExecutor put(Map<String, String> param) {
        return null;
    }

    @Override
    public ApiExecutor send() {
        return null;
    }
}
