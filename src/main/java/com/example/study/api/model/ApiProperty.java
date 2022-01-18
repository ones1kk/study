package com.example.study.api.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

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
