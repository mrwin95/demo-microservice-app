package com.demo.departmentsvc.service;

import com.demo.departmentsvc.entity.Department;
import com.demo.departmentsvc.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository repository;

    @Override
    public Department findDepartmentByCode(String code) {
        return repository.findDepartmentByCode(code);
    }

    @Override
    public Department createDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public Department findDepartmentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("The department not found"));
    }

    @Override
    public void deleteDepartment(Long id) {
        Department deleted = this.findDepartmentById(id);
        repository.delete(deleted);
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department updated = this.findDepartmentById(id);

        //repository.save()
    }
}
