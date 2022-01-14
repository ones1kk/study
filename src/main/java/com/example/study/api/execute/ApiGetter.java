package com.example.study.api.execute;

import com.example.study.api.model.Login;
import com.example.study.api.model.LoginStatus;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public abstract class ApiGetter implements ApiExecutor {

    protected final RestTemplate connection;

    protected final Map<String, Object> bodyMap;

    protected LoginStatus status;


}