package com.demo.employeesvc.client;

import com.demo.commondto.department.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "department-svc", url = "http://localhost:8801/")
@FeignClient(name = "department-svc")
public interface DepartmentClient {

    @GetMapping("/department/departmentId/{departmentId}")
    public DepartmentDTO findDepartmentById(@PathVariable Long departmentId);

}
