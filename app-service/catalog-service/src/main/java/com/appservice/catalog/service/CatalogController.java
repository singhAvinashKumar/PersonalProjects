package com.appservice.catalog.service;

import com.appservice.catalog.model.AppCatalog;
import com.appservice.catalog.model.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CatalogController {

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Value("${Spring.application.name}")
    private String name;*/

    @Autowired
    private CatalogService service;

    @RequestMapping("/home")
    public String getHome(){
        return "Welcome to PlayStore";
    }

    //Get List of Apps
    @RequestMapping("/")
    public List<AppInfo> getAppCatalog(){
        return service.getAppCatalog();
    }

    //Get AppRating
    @RequestMapping("/{appId}")
    public AppCatalog getAppRatings(@PathVariable int appId){

        AppCatalog sendCatalog= service.getAppRating(appId);
        if (sendCatalog.getAppName()==null)
            throw new AppNotFoundException("AppID"+appId);
        return sendCatalog;
    }

}
