package com.example.sc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example"})
@SpringBootApplication
public class ScApp {

    public static void main(String[] args) {
        SpringApplication.run(ScApp.class, args);
    }

}
