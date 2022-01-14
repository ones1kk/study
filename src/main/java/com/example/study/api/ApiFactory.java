package com.example.study.api;

import com.example.study.api.execute.ApiExecutor;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiFactory {

    private static Map<String, ApiExecutor> executor;

    private ApiFactory() {}



    @Autowired
    private void init(Map<String, ApiExecutor> executor) {
        ApiFactory.executor = executor;
    }

    public static ApiExecutor call(String name) {
        return executor.get(name);
    }

}
