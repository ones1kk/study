package com.example.study.refactor.execute.impl;

import com.example.study.refactor.EntitySetterV2;
import com.example.study.refactor.execute.ApiGetterV2;
import com.example.study.refactor.model.ApiProperty;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class LoginExecutor extends ApiGetterV2 {

    public LoginExecutor(ApiProperty apiProperty, EntitySetterV2 entitySetter) {
        super(apiProperty, entitySetter);

    }

    @Override
    public EntitySetterV2 put(Map<String, String> body) {

        return entitySetter.get(body, apiProperty.getUrl().getLogin());
    }
}
