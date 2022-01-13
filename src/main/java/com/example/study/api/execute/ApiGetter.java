package com.example.study.api.execute;

import com.google.gson.JsonObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public abstract class ApiGetter implements ApiExecutor{

    protected final RestTemplate connection;

//    protected final JsonObject json;

    protected final Map<String, Object> queryParam ;

}