package com.example.study.api.execute;

import com.example.study.api.model.LoginStatus;
import java.util.Map;

public interface ApiExecutor {

    public ApiExecutor put(Map<String, Object> param);

    public LoginStatus send(String url);

}