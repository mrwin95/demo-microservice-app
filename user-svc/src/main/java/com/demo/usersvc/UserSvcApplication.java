package com.demo.usersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.demo.usersvc"})
@EnableJpaRepositories
public class UserSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSvcApplication.class, args);
    }

}
