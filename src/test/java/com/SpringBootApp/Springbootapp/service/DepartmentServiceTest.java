package com.SpringBootApp.Springbootapp.service;

import com.SpringBootApp.Springbootapp.entity.Department;
import com.SpringBootApp.Springbootapp.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;


    @BeforeEach
    public void setUp() {
         Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Ahmedabad")
                        .departmentCode("IT-06")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        System.out.println();
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}