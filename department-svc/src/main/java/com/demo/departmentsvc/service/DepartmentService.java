package com.demo.departmentsvc.service;

import com.demo.departmentsvc.entity.Department;

public interface DepartmentService {

    public Department findDepartmentByCode(String code);

    public Department createDepartment(Department department);

    public Department findDepartmentById(Long id);

    public void deleteDepartment(Long id);

    public void updateDepartment(Long id, Department department);

}
