package com.example.restservice;

import com.example.util.CorpPGAdminUtil;
import com.example.util.JavaVersionCheckUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class RestServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        System.out.println("================================================ ====");
        System.out.println("Java Version :: " + System.getProperty("java.version"));
        JavaVersionCheckUtil.getJavaVersion();
        System.out.println("====================================================");

        CorpPGAdminUtil.print();

        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
