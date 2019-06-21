package com.springlec.service;

import java.util.List;

import com.springlec.dao.EmployeeDAO;
import com.springlec.dto.Employee;

public class EmployServiceImpl implements EmployService {
	
	private EmployeeDAO dao;

	public EmployServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public int saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("Service : getAllEmployees");
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

}
