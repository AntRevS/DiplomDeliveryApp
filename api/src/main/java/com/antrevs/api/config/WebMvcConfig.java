package com.antrevs.api.config;

import com.antrevs.api.intercreptor.HeadersInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final HeadersInterceptor headersInterceptor;

    @Autowired
    public WebMvcConfig(HeadersInterceptor headersInterceptor) {
        this.headersInterceptor = headersInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headersInterceptor).addPathPatterns("/private/**");
    }
}
