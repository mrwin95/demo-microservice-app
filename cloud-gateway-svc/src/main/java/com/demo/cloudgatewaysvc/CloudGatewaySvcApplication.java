package com.demo.cloudgatewaysvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewaySvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewaySvcApplication.class, args);
    }

}
