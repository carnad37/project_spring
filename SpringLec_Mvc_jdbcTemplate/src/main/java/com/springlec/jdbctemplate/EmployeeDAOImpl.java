package com.springlec.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

    private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new Employee
    public int saveEmployee(Employee employee)
    {
    	int ret=-1;
        String sql = "insert into Employee values(?,?,?,?)";
        System.out.println("dao called");
        try 
    	{
        	ret=jdbcTemplate.update(sql, new Object[] { employee.getId(), employee.getAge() , employee.getDept(), employee.getName() });
        
    	}
		catch(DataAccessException e)
		{
			System.out.println("insert() - DataAccessException");
			e.getMessage();
			e.printStackTrace();	   
			ret=-1;
		}
        
        return ret;
    }

    // Getting a particular Employee
    public Employee getEmployeeById(int id)
    {
    	
    	System.out.println("getEmployeeById");
    	Employee employee = null;
        String sql = "select * from Employee where id=?";
    	try 
	    {
	    	employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Employee>()
	        {
	            @Override
	            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	            {
	                Employee employee = new Employee();
	                employee.setId(rs.getInt(1));
	                employee.setAge(rs.getInt(2));
	                employee.setDept(rs.getString(3));
	                employee.setName(rs.getString(4));
	                return employee;
	            }
	        });
	    }
 	   catch(DataAccessException e)
		{
			System.out.println("queryForObject() - DataAccessException");
			e.getMessage();
			e.printStackTrace();	   
			
		}
        return employee;
    }

    // Getting all the Employees
    public List<Employee> getAllEmployees()
    {
    	List<Employee> employeeList = null;
        String sql = "select * from Employee";
        
        try 
	    {
	        employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
	        {
	            @Override
	            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
	            {
	                List<Employee> list = new ArrayList<Employee>();
	                while (rs.next())
	                {
	                    Employee employee = new Employee();
	                    employee.setId(rs.getInt(1));
	                    employee.setAge(rs.getInt(2));
	                    employee.setDept(rs.getString(3));
	                    employee.setName(rs.getString(4));
	                    list.add(employee);
	                }
	                return list;
	            }
	
	        });
	    }
 	   catch(DataAccessException e)
		{
			System.out.println("queryForList_getListByDeptno_SetReturnType() - DataAccessException");
			e.getMessage();
			e.printStackTrace();	   
			
		}
        return employeeList;
    }

  
}
