package com.appservice.catalog.model;

import org.springframework.beans.factory.annotation.Autowired;


public class AppRatings {

        private int userId;
        private int userRating;

        @Autowired
        private AppInfo appId;


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

