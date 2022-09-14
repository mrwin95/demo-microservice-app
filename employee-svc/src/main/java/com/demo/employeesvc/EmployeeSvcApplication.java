package com.demo.employeesvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.demo.employeesvc"})
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Employee API", version = ".0", description = "Employee Documentation API"))
public class EmployeeSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSvcApplication.class, args);
    }

}
