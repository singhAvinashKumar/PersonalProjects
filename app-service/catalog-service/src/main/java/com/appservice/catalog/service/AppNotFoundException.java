package com.appservice.catalog.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppNotFoundException extends RuntimeException {
    public AppNotFoundException(String appID){
        super(appID);
    }
}
