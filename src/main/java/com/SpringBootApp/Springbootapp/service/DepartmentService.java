package com.SpringBootApp.Springbootapp.service;

import com.SpringBootApp.Springbootapp.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentbyID(Long departmentId);

    public void deleteDepartmentByID(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);
}
