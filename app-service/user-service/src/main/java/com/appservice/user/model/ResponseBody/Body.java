package com.appservice.user.model.ResponseBody;

import com.appservice.user.model.UserInfo;

public class Body {
    private Iterable<UserInfo> allUser;

    public Body(){

    }
    public Body(Iterable<UserInfo> allUser) {
        this.allUser = allUser;
    }

    public Iterable<UserInfo> getAllUser() {
        return allUser;
    }

    public void setAllUser(Iterable<UserInfo> allUser) {
        this.allUser = allUser;
    }





}
