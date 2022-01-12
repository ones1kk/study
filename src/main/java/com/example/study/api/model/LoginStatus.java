package com.example.study.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginStatus {

    private boolean resultChk;

    private String resultCode;

    private String message;
}
