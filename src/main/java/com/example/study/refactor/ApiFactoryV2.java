package com.example.study.refactor;

import com.example.study.refactor.execute.ApiExecutorV2;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiFactoryV2 {

    private static Map<String, ApiExecutorV2> executor;

    private ApiFactoryV2() {
    }

    @Autowired
    private void init(Map<String, ApiExecutorV2> executor) {
        ApiFactoryV2.executor = executor;
    }

    public static ApiExecutorV2 call(String name) {
        return executor.get(name);
    }

}
