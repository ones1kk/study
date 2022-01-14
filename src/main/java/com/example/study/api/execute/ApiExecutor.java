package com.example.study.api.execute;

import com.example.study.api.model.LoginStatus;
import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface ApiExecutor {

    public ApiExecutor put(Map<String, String> param);

    public ResponseEntity<LoginStatus> send(String url);

}