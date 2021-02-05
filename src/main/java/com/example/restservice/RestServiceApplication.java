package com.example.restservice;

import com.example.util.CorpPGAdminUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("Java Version :: " + System.getProperty("java.version"));
        JavaVersionCheckUtil.getJavaVersion();
        System.out.println("====================================================");

        CorpPGAdminUtil.print();

        SpringApplication.run(RestServiceApplication.class, args);
    }
}
