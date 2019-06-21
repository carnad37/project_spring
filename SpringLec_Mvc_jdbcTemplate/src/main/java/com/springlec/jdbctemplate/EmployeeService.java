package com.springlec.jdbctemplate;

import java.util.List;
public interface EmployeeService
{
    public int saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);

    public List<Employee> getAllEmployees();
}
