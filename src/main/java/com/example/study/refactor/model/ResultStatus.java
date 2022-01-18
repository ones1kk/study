package com.example.study.refactor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultStatus {

    private boolean resultChk;

    private String resultCode;

    private String message;
}
