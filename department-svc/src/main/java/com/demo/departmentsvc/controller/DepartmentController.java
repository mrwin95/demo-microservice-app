package com.demo.departmentsvc.controller;

import com.demo.departmentsvc.client.EmployeeClient;
import com.demo.departmentsvc.entity.Department;
import com.demo.departmentsvc.service.DepartmentService;
import dto.EmployeeDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    private final EmployeeClient employeeClient;

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        log.info("Department added: {}, ", department);
        return departmentService.createDepartment(department);
    }

    @CircuitBreaker(name = "employee-svc", fallbackMethod = "serviceFallback")
    @GetMapping("/{departmentId}")
    public List<EmployeeDTO> findDepartmentById(@PathVariable Long departmentId){
        return employeeClient.findByDepartment(departmentId);
    }

    @GetMapping("/departmentId/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }


    public List<EmployeeDTO> serviceFallback(){
        return Stream.of(
                EmployeeDTO.builder().departmentId(1L).firstName("Thang").lastName("Nguyen").dob(LocalDate.now()).build(),
                EmployeeDTO.builder().departmentId(1L).firstName("Thang").lastName("Nguyen").dob(LocalDate.now()).build()
        ).collect(Collectors.toList());
    }
}
