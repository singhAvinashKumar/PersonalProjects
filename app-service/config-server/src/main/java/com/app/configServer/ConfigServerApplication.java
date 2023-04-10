package com.app.configServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.logging.Logger;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	@Value("${spring.cloud.config.server.git.uri}:lol")
	static String loc;


	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);


		System.out.println(loc);
	}

}
