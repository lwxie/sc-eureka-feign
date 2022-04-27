package com.example.sc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ScEureka {

    public static void main(String[] args) {
        SpringApplication.run(ScEureka.class, args);
    }

}
