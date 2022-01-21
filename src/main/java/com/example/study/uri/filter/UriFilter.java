package com.example.study.uri.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UriFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("===== url filter =====");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        if(req.getRequestURL().toString().equals("http://localhost:8080/move")){
            session.setAttribute("email", "temp");

            String email = (String) session.getAttribute("email");
            log.info("email = {} ", email);
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        log.info(" destroy filter");
    }
}
