package com.demo.employeesvc.service;

import com.demo.employeesvc.entity.Employee;
import com.demo.employeesvc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee findEmployeeByDepartmentId(Long id) {
        return null;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return this.findAll().stream()
                .filter(a -> a.getDepartmentId().equals(departmentId))
                .toList();
    }
}
