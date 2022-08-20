package com.ritwik.EmployeeService.services;

import com.ritwik.EmployeeService.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    Employee saveEmployeeDetails(Employee employee);

}
