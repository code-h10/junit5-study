package com.binary.junit.service;

import com.binary.junit.model.Employee;
import com.binary.junit.model.Office;
import com.binary.junit.repository.EmployeeRepository;
import com.binary.junit.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeService officeService;
    private final OfficeRepository officeRepository;

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
//        try {
            officeService.updateOfficeAddress(employee);
//            updateOfficeAddress(employee);
//        } catch (RuntimeException e) {
//            System.out.println("ERROR=========>" + e);
//        }

//        updateOfficeAddress(employee);
        throw new RuntimeException();

    }

//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public void updateOfficeAddress(Employee employee) {
//        Office office = new Office();
//        office.setOfficeCode(employee.getOfficeCode());
//        office.setAddressLine1("TEST");
//        office.setAddressLine2("TEST");
//        officeRepository.updateAddress(office);
//        throw new RuntimeException();
//    }


}
