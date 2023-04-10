package com.playstore.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeleafConfiguration {



        @Bean
        public SpringTemplateEngine springTemplateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(thymeleafTemplateResolver());
            return templateEngine;
        }

        @Bean
        public SpringResourceTemplateResolver thymeleafTemplateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setPrefix("classpath:/templates/");
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode("HTML");
            return templateResolver;
        }
    }

