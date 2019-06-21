package com.springlec.dao;

import java.util.List;

import com.springlec.dto.Employee;

public interface EmployeeDAO {

    public int saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();
	
}
