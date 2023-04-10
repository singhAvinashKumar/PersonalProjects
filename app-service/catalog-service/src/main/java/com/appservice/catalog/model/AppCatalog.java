package com.appservice.catalog.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class AppCatalog {

    private String appName;
   // @Autowired
    private HashMap<String, Integer> ratings;
    /*@Autowired
    private RatingCatalog ratCat;
    public RatingCatalog getRatCat() {
        return ratCat;
    }
    public void setRatCat(RatingCatalog ratCat) {
        this.ratCat = ratCat;
    }*/
    public  AppCatalog(){
        ratings=new HashMap<>();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public HashMap<String, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<String, Integer> ratings) {
        this.ratings = ratings;
    }
}
