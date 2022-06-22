package com.info.app.service;

import com.info.app.model.AppInfo;
import com.info.app.model.AppRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    private AppService info;

    @RequestMapping("/")
    public Iterable<AppInfo> getAllApps(){

        return info.getAllApps();
    }

    @RequestMapping("/{appId}")
    public Optional<AppInfo> getApp(@PathVariable int appId){
        Optional<AppInfo> temp= info.getApp(appId);
        if(temp.isEmpty()){
             throw new AppNotFoundException("Id "+appId);
        }
        return temp;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String uploadApp(@RequestBody AppInfo a){
         return info.uploadApp(a);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{appId}")
    public String updateApp(@RequestBody AppInfo a){
        a.setAppId((int)a.getAppId());
        return info.uploadApp(a);
    }



    @RequestMapping(method = RequestMethod.DELETE,value = "/{appId}")
    public String deleteApp(@PathVariable int appId){
        return info.deleteApp(appId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/{appId}")
    public String rateApp(@RequestBody AppRating ratings,@PathVariable int appId){
        ratings.setAppId(new AppInfo(appId));
        return info.rateApp(ratings);
    }

    @RequestMapping("/ratings")
    public Iterable<AppRating> getRatings(){
        return  info.getRatings();
    }

}
