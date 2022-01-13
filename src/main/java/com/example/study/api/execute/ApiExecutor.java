package com.example.study.api.execute;

import com.example.study.api.model.LoginStatus;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ApiExecutor {

    public ApiExecutor put(Map<String, Object> param);

    public LoginStatus send(String url);

}