package com.example.study;

import com.example.study.api.model.LoginStatus;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
public class AutoAppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setMaxConnTotal(120)   //연결을 유지할 최대 숫자
            .setMaxConnPerRoute(100)    //특정 경로당 최대 숫자
            .setConnectionTimeToLive(5, TimeUnit.SECONDS)
            .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);  //HttpComponentsClientHttpRequestFactory 생성자에 주입

        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(
            factory);

        return restTemplateBuilder
            .requestFactory(() -> bufferingClientHttpRequestFactory)
            .setConnectTimeout(Duration.ofMillis(5000)) //읽기시간초과, ms
            .setReadTimeout(Duration.ofMillis(5000))    //연결시간초과, ms
            .build();
    }

    @Bean
    public LoginStatus loginStatus() {
        return new LoginStatus();
    }

}
