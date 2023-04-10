package com.playstore.security.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "code")
public class Constant {
    private static int success;
    private static int invalid_Credintials;

    public static int getInvalid_Credintials() {
        return invalid_Credintials;
    }

    public static int getSuccess() {
        return success;
    }


}
