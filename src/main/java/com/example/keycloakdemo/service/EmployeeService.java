package com.example.keycloakdemo.service;

import com.example.keycloakdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohit Phatak
 */
@Service
public class EmployeeService {
    private Map<String, Employee> employees = new HashMap<>();

    public Employee addEmp(Employee employee){
        employees.put(employee.getEmpId(),employee);
        return employee;
    }

    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }
}
