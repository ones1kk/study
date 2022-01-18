package com.example.study.api.execute;

import com.example.study.api.EntitySetter;
import com.example.study.api.model.LoginStatus;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public abstract class ApiGetter implements ApiExecutor {

    protected final RestTemplate connection;

    protected final Map<String, String> bodyMap;

//    protected final ApiProperty apiProperty;

    protected LoginStatus status;

    protected final EntitySetter setter;

    public LoginStatus getResult() {
        return status;
    }


}