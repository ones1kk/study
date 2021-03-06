package com.example.study.uri.interceptor;

import com.example.study.uri.UserRepository;
import com.example.study.uri.annotation.MySecured;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private static String source;
    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {

        // handler 종류 확인 => HandlerMethod 타입인지 체크
        // HandlerMethod가 아니면 그대로 진행
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 형 변환 하기
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // @MySequred 받아오기
        MySecured mySecured = handlerMethod.getMethodAnnotation(MySecured.class);

        // method에 @MySequred가 없는 경우, 즉 인증이 필요 없는 요청
        if (mySecured == null) {
            return true;
        }

        // @MySequred가 있는 경우이므로, 세션이 있는지 체크
        HttpSession session = request.getSession();
        if (session == null) {
            log.info("Access Failed");
            return false;
        }

        // 세션이 존재하면 유효한 유저인지 확인
        String email = (String) session.getAttribute("email");
        if (email == null) {
            log.info("Access Failed");
            return false;
        }

        String requestURL = request.getRequestURL().toString();

        // @TODO 먼저 헤더를 체크해야함
        if (isEqual(requestURL, "http://localhost:8080/move" , "http://localhost:8080/fly")){
            return true;
        }

//        User user = userRepository.findByEmail(email);
//        if(!email.equals(user.getEmail())){
//            return false;
//        }

        {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) throws Exception {
    }

    public static boolean isEqual(String source, String... strs) {
        boolean isEqual = false;
        for (String str : strs)
        {
            isEqual =  source.toString().equals(str);
        }
        return isEqual;
    }
}
