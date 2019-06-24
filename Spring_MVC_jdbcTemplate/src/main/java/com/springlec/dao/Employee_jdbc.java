package com.springlec.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springlec.dto.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class Employee_jdbc implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;	

	public Employee_jdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int saveEmployee(Employee employee) {
		String SQL = "INSERT INTO employee(id, name, age, dept) VALUES(?, ?, ?, ?)";
		int retval = 0;
		try {
			retval = jdbcTemplate.update(SQL, new Object[] {employee.getId(), employee.getName(), employee.getAge(), employee.getDept()});
		} catch (DataAccessException e) {
			System.out.println("SQL : DATA INSERT FAIL...");
		}
		return retval;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String SQL = "SELECT * FROM employee WHERE id = ?";
		Employee employee = null;
		try {
			employee = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Employee>(Employee.class));
		} catch (DataAccessException e) {
			System.out.println("SQL : DATA SELECT FAIL...");
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String SQL = "SELECT * FROM employee";
		List<Employee> eList = null;
		try {
			eList = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<Employee>(Employee.class));
		} catch (DataAccessException e) {
			System.out.println("SQL : DATA SELECT FAIL...");
		}
		return eList;

//    	List<Employee> employeeList = null;
//        String sql = "select * from Employee";
//        
//        try 
//	    {
//	        employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
//	        {
//	            @Override
//	            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
//	            {
//	                List<Employee> list = new ArrayList<Employee>();
//	                while (rs.next())
//	                {
//	                    Employee employee = new Employee();
//	                    employee.setId(rs.getInt("id"));
//	                    employee.setAge(rs.getInt("age"));
//	                    employee.setDept(rs.getString("dept"));
//	                    employee.setName(rs.getString("name"));
//	                    list.add(employee);
//	                }
//	                return list;
//	            }
//	
//	        });
//	    }
// 	   catch(DataAccessException e)
//		{
//			System.out.println("queryForList_getListByDeptno_SetReturnType() - DataAccessException");
//			e.getMessage();
//			e.printStackTrace();	   
//			
//		}
//        return employeeList;
	}


	
}
