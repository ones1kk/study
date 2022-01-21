package com.example.study.uri.config;

import com.example.study.uri.filter.UriFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final HandlerInterceptor authInterceptor;

    @Bean
    public FilterRegistrationBean<UriFilter> uriFilterRegistrationBean() {
        FilterRegistrationBean<UriFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UriFilter());
        registrationBean.addUrlPatterns("/move");
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/login");
    }

}
