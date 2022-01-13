package com.example.study.api.execute;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class ApiSetter<T extends HttpEntity<T>> {

    private final T status;

    public void set() {
        HttpHeaders headers = status.getHeaders();


    }

}
