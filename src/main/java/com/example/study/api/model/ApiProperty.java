package com.example.study.api.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Data
@ConstructorBinding
@ConfigurationProperties("api")
public class ApiProperty {

    private final String appKey;

    private final Url url;

    @Data
    public static class Url {
        private final String login;
    }

}
