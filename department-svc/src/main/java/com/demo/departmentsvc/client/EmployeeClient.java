package com.demo.departmentsvc.client;


import dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "employee-svc", url = "http://localhost:8802")
@FeignClient(name = "employee-svc")
public interface EmployeeClient {

    @GetMapping
    public List<EmployeeDTO> findAll();

    @GetMapping("/employee/department/{departmentId}")
    public List<EmployeeDTO> findByDepartment(@PathVariable Long departmentId);

}
