package com.example.study;

import com.example.study.api.ApiFactory;
import com.example.study.api.execute.ApiExecutor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RequiredArgsConstructor
public class ApiExecuteApplication {

    public static void main(String[] args) throws MalformedURLException {
        ApplicationContext ap = new AnnotationConfigApplicationContext(
            AutoAppConfig.class);
        ApiExecutor apiExecutor = ap.getBean("loginApiExecutor",
            ApiExecutor.class);

        System.out.println("apiExecutor = " + apiExecutor);

        Map<String, Object> param = new HashMap<>();
        param.put("id", "hello");
        param.put("pw", "bye");


        // URL apiUrl = new URL("test url");
        /**
         * 요구 사항
         * 1. 어떤 Api를 호출할 것인가?
         * 2. 전달할 값은 무엇인가?
         * 3. 어디로 보낼 것인가?
         */
        ApiFactory.call("loginApiExecutor").put(param).send("apiUrl");

    }
}
