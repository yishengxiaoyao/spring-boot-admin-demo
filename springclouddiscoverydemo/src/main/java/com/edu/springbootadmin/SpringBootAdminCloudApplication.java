package com.edu.springbootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootAdminCloudApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootAdminCloudApplication.class,args);
    }
}
