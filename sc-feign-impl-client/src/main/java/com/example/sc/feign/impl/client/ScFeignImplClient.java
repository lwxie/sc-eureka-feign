package com.example.sc.feign.impl.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ScFeignImplClient {

    public static void main(String[] args) {
        SpringApplication.run(ScFeignImplClient.class, args);
    }

}
