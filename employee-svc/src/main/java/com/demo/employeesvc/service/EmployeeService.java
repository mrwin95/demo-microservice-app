package com.demo.employeesvc.service;

import com.demo.employeesvc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee createEmployee(Employee employee);

    public Employee findEmployeeByDepartmentId(Long id);

    public Employee findEmployeeById(Long id);

    public void deleteEmployee(Long id);

    public void updateEmployee(Employee employee);

    public List<Employee> findByDepartment(Long departmentId);
}
