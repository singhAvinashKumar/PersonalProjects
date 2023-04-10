package com.appservice.user.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
@Component
public class Validator {
    Logger logger = LoggerFactory.getLogger(Validator.class);

    // Evaluate email wicked.avinash@gmail.com
    public boolean isValidEmail(String email) {
        logger.info("Checking Email");

        boolean result = Pattern.matches("^[a-zA-Z0-9.]+@[a-z]+\\.com$", email);
        logger.info("Email ID : "+result);
        return result;
    }

    // AlphaNumericPassword
    public boolean isValidPassword(String password){
        boolean result = Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",password);
        logger.info(" " + result);
        return result;
    }



}
