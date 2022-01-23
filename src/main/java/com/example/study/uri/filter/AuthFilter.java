package com.example.study.uri.filter;

import com.example.study.uri.interceptor.AuthInterceptor;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

public class AuthFilter extends GenericFilterBean {

    // Spring security configure.addFilterBefore
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        AuthInterceptor.isEqual(req.getRequestURL().toString(), "http://localhost:8080/move");
        chain.doFilter(request, response);

    }
}
