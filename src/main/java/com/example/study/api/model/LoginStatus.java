package com.example.study.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class LoginStatus {

    private boolean resultChk;

    private String resultCode;

    private String message;
}
