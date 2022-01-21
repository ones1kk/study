package com.example.study;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationPropertiesScan
@ComponentScan
public class ApiExecuteApplication {

    public static void main(String[] args) {
//        ApplicationContext ap = new AnnotationConfigApplicationContext(
//            AutoAppConfig.class);
//
//        Map<String, String> param = new HashMap<>();
//        param.put("id", "hello");
//        param.put("pw", "bye");

        /*
         * 요구 사항
         * 1. 어떤 Api를 호출할 것인가?
         * 2. 전달할 값은 무엇인가? (전송 파라미터) map or vo(?)
         * 3. 어디로 보낼 것인가? + (헤더 파라미터)
         * 4. return 값을 어떻게 받을 것인가?
         */
//        ApiExecutor loginApiExecutor = ApiFactory.call("loginApiExecutor").put(param);
//        loginApiExecutor.getResult();
//        LoginStatus status = ApiFactory.call("loginApiExecutor").put(param).send().getResult();
//        System.out.println("status = " + status);
//
//        ApiFactoryV2.call("loginExecutor").put(param).send();
//
//        ResultStatus resultStatus = ApiFactoryV2.call("loginExecutor").put(param).send()
//            .getStatus();
//
//        System.out.println("resultStatus = " + resultStatus);
//
//        List<Field> list = Arrays.asList(status.getClass().getDeclaredFields());

    }
}
