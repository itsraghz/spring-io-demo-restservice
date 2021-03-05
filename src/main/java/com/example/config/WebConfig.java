package com.example.config;

import com.example.interceptor.LoggerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final Logger logger
            = LoggerFactory.getLogger(WebConfig.class);
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("[*][*] Adding LoggerInterceptor to the registry..");
        registry.addInterceptor(new LoggerInterceptor());
    }
}