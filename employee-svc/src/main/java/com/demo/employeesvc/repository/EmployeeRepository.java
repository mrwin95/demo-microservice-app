package com.demo.employeesvc.repository;

import com.demo.employeesvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findEmployeeByDepartmentId(Long departmentId);

    public List<Employee> findByDepartmentId(Long departmentId);
}

