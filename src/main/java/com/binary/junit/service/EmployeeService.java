package com.binary.junit.service;

import com.binary.junit.model.Employee;
import com.binary.junit.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee getEmployeeByEmployeeNumber(int employeeNumber) {
        return employeeRepository.getEmployeeByEmployeeNumber(employeeNumber);
    }
}
