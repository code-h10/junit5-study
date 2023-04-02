package com.binary.junit.service;

import com.binary.junit.model.Employee;
import com.binary.junit.model.Office;
import com.binary.junit.repository.EmployeeRepository;
import com.binary.junit.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeService officeService;

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee getEmployeeByEmployeeNumber(int employeeNumber) {
        return employeeRepository.getEmployeeByEmployeeNumber(employeeNumber);
    }

    @Transactional
    public void updateJobTitle() throws Exception {

        Employee employee = new Employee();
        employee.setEmployeeNumber(1002);
        employee.setJobTitle("TEST");
        employee.setOfficeCode("1");
        employeeRepository.updateJobTitle(employee);
        officeService.updateOfficeAddress(employee);

    }


}
