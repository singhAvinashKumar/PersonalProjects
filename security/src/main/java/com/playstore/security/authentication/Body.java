package com.playstore.security.authentication;

public class Body {
    private Status status;
    private String accessToken;

    public Body(){

    }
    public Body(Status status){
        this.status = status;
    }

    public Body(Status status, String accessToken) {
        this.status = status;
        this.accessToken = accessToken;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
