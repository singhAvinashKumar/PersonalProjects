package com.playstore.security.model;

import com.playstore.security.authentication.AuthenticationRequest;
import com.playstore.security.authentication.AuthenticationResponse;
import com.playstore.security.authentication.Body;
import com.playstore.security.authentication.Status;
import com.playstore.security.configuration.PlayStoreUserService;
import com.playstore.security.util.Constant;
import com.playstore.security.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@RestController("/api")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PlayStoreUserService playStoreUserService;

    @Autowired
    private JwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @GetMapping("/api/login")
    public ModelAndView showLoginForm() {
        logger.info("showLoginForm Invoked");
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("title", "Login Form");
        return mav;
    }
    @GetMapping("/api/user")
    public String getUser() {
        //ModelAndView mav = new ModelAndView("login");
        //mav.addObject("title", "Login Form");
        logger.info("User endpoint is invoked");
        return "Avinash";
    }
    //Step 1 : Use Authentication Manager to authenticate request
    //Step 2 : If Successfull fetch UserDetails using loadByUserName call
    //Step 3 : generate JWT
    @PostMapping("/api/login")
    public ResponseEntity<AuthenticationResponse> processLogin(@RequestBody AuthenticationRequest request) throws Exception {
        logger.info("processLogin is Invoked : User = " + request.getUserName());
        UUID txId = UUID.randomUUID();
        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword())
        );
            logger.info("Attempting authenticationManager.authenticate");
        }catch (BadCredentialsException e){
            logger.info("Exception Occured",e);
            Body responseBody = new Body(new Status(Constant.getInvalid_Credintials(),"Invalid User Id/Password", HttpStatus.BAD_REQUEST));
            return ResponseEntity.ok().body(
                    new AuthenticationResponse(txId, new Date(), txId, responseBody , "login"));
        }
        final UserDetails userDetails = playStoreUserService.loadUserByUsername(request.getUserName());
        logger.info("User Details: ",userDetails);
        final String jwt
                = jwtUtil.generateToken(userDetails);
        logger.info("access_token : "+jwt);

        Body responseBody = new Body(new Status(0,"Success", HttpStatus.OK),jwt);
        ResponseEntity<AuthenticationResponse> login_successful = ResponseEntity.ok().body(
                new AuthenticationResponse(txId, new Date(), txId, responseBody , "login"));
        logger.info("Login Successfull : ",login_successful);
        return login_successful;
    }

 /*   @PostMapping("/api/login")
    public ModelAndView processLoginForm(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        ModelAndView mav = new ModelAndView("success");
        mav.addObject("username", username);
        mav.addObject("password", password);
        return mav;
    }*/

}
