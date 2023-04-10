package com.appservice.catalog.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RatingCatalog {


    @Autowired
    private List<String> userName;
    @Autowired
    private List<Integer> userRatings;

    public RatingCatalog(){
    }


    public List<String> getUserName() {
        return userName;
    }

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }

    public List<Integer> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Integer> userRatings) {
        this.userRatings = userRatings;
    }


}
