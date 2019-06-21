package com.springlec.service;

import java.util.List;

import com.springlec.dto.Employee;

public interface EmployService {
	
    public int saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();
	
}
