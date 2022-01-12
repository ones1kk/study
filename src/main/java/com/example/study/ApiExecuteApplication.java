package com.example.study;

import com.example.study.api.ApiFactory;
import com.example.study.api.AutoAppConfig;
import com.example.study.api.execute.ApiExecutor;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@RequiredArgsConstructor
public class ApiExecuteApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AutoAppConfig.class);
        ApiExecutor apiExecutor = applicationContext.getBean("ApiExecutor",
                ApiExecutor.class);
        System.out.println("apiExecutor = " + apiExecutor);

        ApplicationContext ap = new AnnotationConfigApplicationContext();
        Map<String, Object> param = new HashMap<>();
        param.put("test", "test");
        ApiFactory.create("loginApiExecutor").write(param).send();
    }
}
