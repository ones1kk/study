package com.example.study.api;

import com.example.study.api.execute.ApiExecutor;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class ApiFactory {

    private static final Map<String, ApiExecutor> executor = null;

    public static ApiExecutor create(String name) {
        return executor.get(name);
    }
}
