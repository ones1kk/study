package com.example.study.refactor.execute;

import com.example.study.refactor.EntitySetterV2;
import com.example.study.refactor.model.ApiProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public abstract class ApiGetterV2 implements ApiExecutorV2 {

    protected final ApiProperty apiProperty;

    protected final EntitySetterV2 entitySetter;

    protected static String url;
}
