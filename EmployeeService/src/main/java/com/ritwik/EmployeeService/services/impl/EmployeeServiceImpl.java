package com.ritwik.EmployeeService.services.impl;

import com.ritwik.EmployeeService.daos.impl.EmployeeDaoImpl;
import com.ritwik.EmployeeService.entities.Employee;
import com.ritwik.EmployeeService.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Override
    public Employee getEmployeeById(int employeeId) {

        try {
            Thread.sleep(1000*7);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return employeeDao.getEmployeeDetails(employeeId);

    }

    @Override
    public List<Employee> getAllEmployees() {

         try {
             Thread.sleep(1000*7);
         }catch (Exception e) {
             e.printStackTrace();
         }

         return employeeDao.getAllEmployee();

    }

    @Override
    public Employee saveEmployeeDetails(Employee employee) {

        employeeDao.saveEmployeeDetails(employee);
        return employee;

    }
}
