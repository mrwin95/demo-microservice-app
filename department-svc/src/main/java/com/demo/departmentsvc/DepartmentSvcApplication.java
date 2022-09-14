package com.demo.departmentsvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.demo.departmentsvc"})
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Department API", version = ".0", description = "Department Documentation API"))
public class DepartmentSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentSvcApplication.class, args);
    }

}
