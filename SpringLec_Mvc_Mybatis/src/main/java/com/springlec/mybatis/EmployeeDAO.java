package com.springlec.mybatis;

import java.util.List;
public interface EmployeeDAO
{
    public int saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);

    public List<Employee> getAllEmployees();
}
