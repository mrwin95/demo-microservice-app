package com.demo.employeesvc.controller;

import com.demo.commondto.department.dto.DepartmentDTO;
import com.demo.employeesvc.client.DepartmentClient;
import com.demo.employeesvc.entity.Employee;
import com.demo.employeesvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final DepartmentClient departmentClient;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){

        employee.setDob(LocalDate.now());
        DepartmentDTO departmentDTO = departmentClient.findDepartmentById(employee.getDepartmentId());
        log.info("department" + departmentDTO.getId());
        employee.setDepartmentId(departmentDTO.getId());
        Employee saved = employeeService.createEmployee(employee);

        log.info("Employee added: {}, ", saved);
        return saved;
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId){
        log.info("Employee find: departmentId {}, ", departmentId);
        return employeeService.findByDepartment(departmentId);
    }
}
