package com.app.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo   {
    @Id
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userID) {
        this.userId = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
