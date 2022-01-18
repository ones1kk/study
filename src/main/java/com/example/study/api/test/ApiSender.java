package com.example.study.api.test;

import com.example.study.api.model.LoginStatus;

public class ApiSender {

    private LoginStatus status;

    public void send() {
        status = null;
    }

    public LoginStatus getResultStatus() {
        return status;
    }

}
