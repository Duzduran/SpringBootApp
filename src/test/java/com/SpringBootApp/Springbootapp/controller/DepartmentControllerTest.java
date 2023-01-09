package com.SpringBootApp.Springbootapp.controller;

import com.SpringBootApp.Springbootapp.entity.Department;
import com.SpringBootApp.Springbootapp.error.DepartmentNotFoundException;
import com.SpringBootApp.Springbootapp.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp(){
        department = Department.builder()
                .departmentAddress("Unalan")
                .departmentCode("UN-08")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDep = Department.builder()
                .departmentAddress("Unalan")
                .departmentCode("UN-08")
                .departmentName("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDep)).thenReturn(department);
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IT\",\n" +
                        "    \"departmentAddress\":\"Unalan\",\n" +
                        "    \"departmentCode\": \"UN-08\"\n" +
                        "    }")).andExpect(status().isOk());


    }


    @Test
    void fetchDepartmentbyID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentbyID(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}