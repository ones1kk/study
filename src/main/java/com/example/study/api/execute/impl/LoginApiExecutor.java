package com.example.study.api.execute.impl;

import com.example.study.api.execute.ApiExecutor;
import com.example.study.api.execute.ApiGetter;
import com.example.study.api.model.Login;
import com.example.study.api.model.LoginStatus;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LoginApiExecutor extends ApiGetter {

    //    @Value("${api.url.login}")
//    private String url;

    public LoginApiExecutor(RestTemplate connection, Map<String, Object> queryParam) {
        super(connection, queryParam);
    }

    @Override
    public ApiExecutor put(Map<String, Object> param) {
        queryParam.putAll(param);
        return this;
    }

    @Override
    public LoginStatus send(String url) {
        System.out.println("LoginApiExecutor.send");
        queryParam.forEach((s, o) -> System.out.println(s + " : " + o));
//        HttpHeaders header = new HttpHeaders();
//        HttpEntity<?> entity = new HttpEntity<>(header);
//
//        url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json") ;
//        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "key=key&targetDt=20210201")
//            .encode(StandardCharsets.UTF_8)
////            .queryParams()
//            .build();
//
//        ResponseEntity<Object> exchange = connection.exchange(uri.toString(), HttpMethod.POST, entity, Object.class);
//
//        System.out.println("exchange = " + exchange);
//
//        HttpStatus statusCode = exchange.getStatusCode();   //상태코드확인
//        HttpHeaders headers = exchange.getHeaders();    //헤더정보확인
//        Object body = exchange.getBody();   //바디정보확인

        return null;
    }
}
