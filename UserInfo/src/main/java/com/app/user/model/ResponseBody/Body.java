package com.app.user.model.ResponseBody;

import com.app.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

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
