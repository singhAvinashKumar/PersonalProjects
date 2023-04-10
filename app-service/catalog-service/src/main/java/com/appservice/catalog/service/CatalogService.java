package com.appservice.catalog.service;

import com.appservice.catalog.model.AppCatalog;
import com.appservice.catalog.model.AppInfo;
import com.appservice.catalog.model.AppRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private ConnectApi connect;

    @Autowired
    private List<AppInfo> appList;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private List<AppRatings> appRatings ;

   // @Autowired
    private AppCatalog catalog;

    public List<AppInfo> getAppList() {
        return appList;
    }

    public void setAppList(List<AppInfo> appList) {
        this.appList = appList;
    }

    //List of Apps;

    public List<AppInfo> getAppCatalog(){
       // RestTemplate restTemplate =new RestTemplate();

        ResponseEntity<List<AppInfo>> claimResponse=connect.getAppList();
        if (claimResponse!=null&&claimResponse.hasBody())
            appList=claimResponse.getBody();

        return appList;

    }


    //Return ratings for requested App
    public AppCatalog getAppRating(int appId) {
        //  List<AppCatalog> sendList=new ArrayList<>();
        catalog=new AppCatalog();
        String tempUserId=null;
        String tempUserName=null;
       // RestTemplate template =new RestTemplate();

        ResponseEntity<List<AppRatings>> response=connect.getAppRatings();

        if (response!=null&&response.hasBody()){
            appRatings=response.getBody();

                List<AppInfo> listApp= getAppCatalog();
                for (AppInfo info : listApp){
                    if (info.getAppId()==appId)
                        catalog.setAppName(info.getAppName());
                }

                for (AppRatings a : appRatings){
                    if (a.getAppId().getAppId()==appId){
                      //  catalog.setAppName(a.getAppId().getAppName());
                        try {
                            tempUserId= String.valueOf(a.getUserId());
                            tempUserName=connect.setUserNameCustom(tempUserId);
                            catalog.getRatings().put(tempUserName,a.getUserRating());
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            System.out.println(e);
                        }
                        //sendList.add(catalog);
                    }

                }
            }


        return catalog;

    }




}
