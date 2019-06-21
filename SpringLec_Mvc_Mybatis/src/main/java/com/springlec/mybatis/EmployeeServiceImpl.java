package com.springlec.mybatis;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO empDao;
	public EmployeeDAO getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public int saveEmployee(Employee employee) {
		return empDao.saveEmployee(employee);

	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return empDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
	}

}
