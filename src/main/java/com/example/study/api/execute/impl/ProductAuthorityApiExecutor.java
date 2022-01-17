package com.example.study.api.execute.impl;

import com.example.study.api.EntitySetter;
import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.ApiProperty;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class ProductAuthorityApiExecutor extends ApiGetter {

    public ProductAuthorityApiExecutor(RestTemplate connection,
        Map<String, Object> bodyMap, EntitySetter setter, ApiProperty apiProperty) {
        super(connection, bodyMap, apiProperty, setter);
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
