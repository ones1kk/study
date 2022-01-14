package com.example.study;

import com.example.study.api.ApiFactory;
import com.example.study.api.model.LoginStatus;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class ApiExecuteApplication {

    public static void main(String[] args) throws MalformedURLException {
        ApplicationContext ap = new AnnotationConfigApplicationContext(
            AutoAppConfig.class);
//        ApiExecutor apiExecutor = ap.getBean("loginApiExecutor",
//            ApiExecutor.class);

//        System.out.println("apiExecutor = " + apiExecutor);

        Map<String, String> param = new HashMap<>();
        param.put("id", "hello");
        param.put("pw", "bye");

        // URL apiUrl = new URL("test url");
        /**
         * 요구 사항
         * 1. 어떤 Api를 호출할 것인가?
         * 2. 전달할 값은 무엇인가? (전송 파라미터) map or vo(?)
         * 3. 어디로 보낼 것인가? + (헤더 파라미터)
         * 4. return 값을 어떻게 받을 것인가?ㅊㅍ
         */
        ResponseEntity<LoginStatus> test = ApiFactory.call("loginApiExecutor").put(param)
            .send("apiUrl");
        System.out.println(
            "============================================================================");
        HttpStatus statusCode = test.getStatusCode();   //상태코드확인
        HttpHeaders headers = test.getHeaders();    //헤더정보확인
        LoginStatus body = test.getBody();   //바디정보확인

        System.out.println("statusCode = " + statusCode);
        System.out.println("headers = " + headers);
        System.out.println("body = " + body);
    }
}
