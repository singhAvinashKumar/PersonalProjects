package com.appservice.appInfo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Component
public class AppInfo {
    @Id
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
