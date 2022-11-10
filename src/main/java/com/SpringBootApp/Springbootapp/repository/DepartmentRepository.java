package com.SpringBootApp.Springbootapp.repository;


import com.SpringBootApp.Springbootapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
