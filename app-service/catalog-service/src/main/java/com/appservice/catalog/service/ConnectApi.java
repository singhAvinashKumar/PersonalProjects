package com.appservice.catalog.service;

import com.appservice.catalog.model.AppInfo;
import com.appservice.catalog.model.AppRatings;
import com.appservice.catalog.model.UserInfo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ConnectApi {



    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name="Catalog")
    public ResponseEntity<List<AppRatings>> getAppRatings() {
        HttpHeaders header=new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity=new HttpEntity<>(header);

        ResponseEntity<List<AppRatings>> response=restTemplate.exchange(
                "http://AppInfo/ratings",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<AppRatings>>() {});
        return response;
    }


    // int count=0;
    @CircuitBreaker(name="Catalog",fallbackMethod = "setDefaultUserName")
    @Retry(name = "Catalog")
    @RateLimiter(name = "Catalog")
    public String setUserNameCustom(String tempUserId){
        UserInfo info = null;
       // System.out.println("count"+count);
        //RestTemplate template =new RestTemplate();
        HttpHeaders header=new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity=new HttpEntity<>(header);
        ResponseEntity<UserInfo> responseTwo=restTemplate.exchange("http://UserInfo/"+tempUserId,HttpMethod.GET,requestEntity,UserInfo.class);
        if (responseTwo!=null&&responseTwo.hasBody()){
            info=responseTwo.getBody();
            System.out.println(info.getUserName()+info.getUserId());

        }
        String userName = info.getUserName();
        return userName;
    }

    public String setDefaultUserName(Exception e){
        return "Username not found";
    }

    @CircuitBreaker(name = "Catalog",fallbackMethod = "getDefaultCatalog")
    public ResponseEntity<List<AppInfo>> getAppList() {
        HttpHeaders header =new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity =new HttpEntity<>(header);
        ResponseEntity<List<AppInfo>> claimResponse = restTemplate.exchange(
                "http://AppInfo",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<AppInfo>>() {});
        return  claimResponse;
    }
    //Fallback method
    public ResponseEntity<List<AppInfo>> getDefaultCatalog(Exception e){
        return null;
    }
}
