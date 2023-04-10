package com.appservice.appInfo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Component
@Entity
public class AppRating {
    @Id
    private int userId;
    private int userRating;

    @Autowired
    @OneToOne
    private AppInfo appId;

    public AppRating() {
    }

    public AppInfo getAppId() {
        return appId;
    }

    public void setAppId(AppInfo appId) {
        this.appId = appId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}
