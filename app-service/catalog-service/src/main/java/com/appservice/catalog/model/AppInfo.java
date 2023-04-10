package com.appservice.catalog.model;


import org.springframework.context.annotation.Bean;

public class AppInfo {

    private int appId;
    private String appName;
    private String appType;

    public AppInfo() {
    }


    public AppInfo(int appId,String appName,String appType){
        this.appId=appId;
        this.appName=appName;
        this.appType=appType;
    }

    public AppInfo(int appId) {
        this.appId=appId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }



}
