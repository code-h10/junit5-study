package com.binary.junit.controller;

import com.binary.junit.model.Employee;
import com.binary.junit.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/detail")
    public Employee getEmployeeByEmployeeNumber(int employeeNumber) {
        return employeeService.getEmployeeByEmployeeNumber(employeeNumber);
    }

    @PutMapping("/jobTitle")
    public void updateJobTitle() throws Exception {
        employeeService.updateJobTitle();
    }
}
