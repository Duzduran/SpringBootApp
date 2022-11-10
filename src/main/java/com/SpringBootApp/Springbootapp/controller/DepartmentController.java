package com.SpringBootApp.Springbootapp.controller;

import com.SpringBootApp.Springbootapp.entity.Department;
import com.SpringBootApp.Springbootapp.service.DepartmentService;
import com.SpringBootApp.Springbootapp.service.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentbyID(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentbyID(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentByID(departmentId);
        return  "Department deleted Successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long  departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }
}
