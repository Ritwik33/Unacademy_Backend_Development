package com.ritwik.EmployeeService.daos;

import com.ritwik.EmployeeService.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployeeDetails(int employeeId);
    List<Employee> getAllEmployee();
    Employee saveEmployeeDetails(Employee employee);

}
