package com.graduation.demo.springbootswagger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SwaggerConfig {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerConfig.class, args);
    }

@Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
               // .paths(PathSelectors.ant("*/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.graduation.demo.controller"))
                .build();



    }


   /* private ApiInfo info(){
        return new ApiInfo(
                "graduation project online exam",
                "1.0"
               // Collections.emptyList()
        );

    }*/


}
