package com.info.app;

import com.info.app.service.AppService;
import com.info.app.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication

public class AppApplication {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public JwtUtil getJwtUtil(){
        return new JwtUtil();
    }



    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
