package com.appservice.appInfo.service;

import com.appservice.appInfo.security.MyUserDetailsService;
import com.appservice.appInfo.model.AppInfo;
import com.appservice.appInfo.model.AppRating;
import com.appservice.appInfo.model.AuthenticateRequest;
import com.appservice.appInfo.model.AuthenticateResponse;
import com.appservice.appInfo.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RefreshScope
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private AppService info;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(method = RequestMethod.POST,value = "/authenticate")
    public ResponseEntity<?> doAuthentication(@RequestBody AuthenticateRequest request) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUserName(),request.getPassword())
            );
        } catch (BadCredentialsException e){
                throw new Exception("Bad Credentials",e);
        }
        UserDetails userDetails= userDetailsService.loadUserByUsername(request.getUserName());
        final String jwt=jwtUtil.generateToken(userDetails);
        System.out.println("what's JWT" + jwt);
        return  ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

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
        if (logger.isDebugEnabled())
            logger.debug("Get ratings has been requested by " );
        return  info.getRatings();
    }

}
