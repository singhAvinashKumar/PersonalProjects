package com.appservice.catalog;

import com.appservice.catalog.model.AppCatalog;
import com.appservice.catalog.model.AppInfo;
import com.appservice.catalog.model.AppRatings;
import com.appservice.catalog.model.RatingCatalog;
import com.appservice.catalog.service.ConnectApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class CatalogApplication {
    @Bean
    public List<AppInfo> getAppList(){
        return new ArrayList<>();
    }
    @Bean
    public ConnectApi getConnection(){
        return new ConnectApi();
    }
    @Bean
    public AppInfo getAppInfo(){
        return new AppInfo();
    }
    @Bean
    public RatingCatalog getRatingCatalog(){
        return new RatingCatalog();
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public HashMap<String,Integer> getHashMap(){
        return new HashMap<>();
    }

    @Bean
    public List<String> getUserNameList(){
        return new ArrayList<>();
    }
    @Bean
    public List<Integer> getUserRatingsList(){
        return new ArrayList<>();
    }


    @Bean
    public AppCatalog getCatalog(){
        return new AppCatalog();
    }

    @Bean
    public AppRatings getAppRatings(){
        return new AppRatings();
    }
    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }

}
