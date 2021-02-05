package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("Java Version :: " + System.getProperty("java.version"));
        JavaVersionCheckUtil.getJavaVersion();
        System.out.println("====================================================");

        SpringApplication.run(RestServiceApplication.class, args);
    }
}
