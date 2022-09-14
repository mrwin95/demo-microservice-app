package com.demo.cloudnamingsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudNamingSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNamingSvcApplication.class, args);
    }

}
