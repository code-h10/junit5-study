package com.binary.junit.controller;

import com.binary.junit.model.Employee;
import com.binary.junit.repository.EmployeeRepository;
import com.binary.junit.service.EmployeeService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private EmployeeService employeeService;
    private static Employee employee;

    @BeforeClass
    public static void setUp() {
        employee = new Employee();
        employee.setEmployeeNumber(1003);
        employee.setLastName("Hwang");
        employee.setFirstName("IlYoung");
        employee.setExtension("x5024");
        employee.setEmail("test@gmail.com");
        employee.setOfficeCode("1");
        employee.setReportsTo(1002);
        employee.setJobTitle("Sales Rep");
    }

    @Test
    public void testEmployees() throws Exception {

        when(employeeService.getEmployeeByEmployeeNumber(anyInt())).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/detail").param("employeeNumber", "1003"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().string("{\"employeeNumber\":1002,\"lastName\":\"Hwang\",\"firstName\":\"IlYoung\",\"extension\":\"x5024\",\"email\":\"test@gmail.com\",\"officeCode\":\"1\",\"reportsTo\":1002,\"jobTitle\":\"Sales Rep\"}"))
                .andDo(print());
    }


}