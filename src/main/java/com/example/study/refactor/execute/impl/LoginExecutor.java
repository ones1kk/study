package com.example.study.refactor.execute.impl;

import com.example.study.refactor.EntitySetterV2;
import com.example.study.refactor.execute.ApiGetterV2;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginExecutor extends ApiGetterV2 {

    public LoginExecutor(EntitySetterV2 entitySetterV2, RestTemplate restTemplate) {
        super(entitySetterV2, restTemplate);
    }

    @Override
    public EntitySetterV2 put(Map<String, String> param) {
        return new EntitySetterV2(param, url);
    }
}
