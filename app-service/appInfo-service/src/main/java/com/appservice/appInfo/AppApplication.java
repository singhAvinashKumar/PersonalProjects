package com.appservice.appInfo;

import com.appservice.appInfo.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
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
