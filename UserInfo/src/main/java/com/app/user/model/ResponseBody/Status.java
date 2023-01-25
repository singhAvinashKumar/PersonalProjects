package com.app.user.model.ResponseBody;

import org.springframework.http.HttpStatus;

public class Status {
    private int code;
    private String message;
    private HttpStatus shortCode;


    public Status(int code, String message,HttpStatus shortCode) {
        this.code = code;
        this.message = message;
        this.shortCode = shortCode;
    }

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getShortCode() {
        return shortCode;
    }

    public void setShortCode(HttpStatus shortCode) {
        this.shortCode = shortCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
