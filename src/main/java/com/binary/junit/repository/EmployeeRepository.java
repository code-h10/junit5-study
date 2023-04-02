package com.binary.junit.repository;

import com.binary.junit.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeRepository {

    List<Employee> getEmployees();
    Employee getEmployeeByEmployeeNumber(int employeeNumber);
    void updateJobTitle(Employee employee);

}
