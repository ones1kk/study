package com.example.study.api.model;

import com.example.study.api.model.ApiProperty.Api.Url;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties("api")
public class ApiProperty {

    private final Api api;

    private final Url url;

    @Data
    public static class Api {

        private final String appKey;

        @Data
        public static class Url {

            private final String login;

        }
    }

}
