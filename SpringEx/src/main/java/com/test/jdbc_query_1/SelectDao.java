package com.test.jdbc_query_1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;


public class SelectDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SelectDao() {
	}
	
	public List<String> getNameList(int deptno) {
		String SQL = "SELECT ename FROM emp WHERE deptno = ?";
		List<String> list = null;
		try {
			list = jdbcTemplate.queryForList(SQL, new Object[] {deptno}, String.class);
//			jdbcTemplate.queryForList("SELECT * FROM emp");
		} catch (DataAccessException e) {
			System.out.println("DataAccessException : getNameList()");
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Emp> getEmpListByQueryForList(int deptno) {
		String SQL = "SELECT * FROM emp WHERE deptno = ?";
		List<Emp> list = null;
		try {
			list = jdbcTemplate.query(SQL, new Object[] {deptno},  new BeanPropertyRowMapper<Emp>(Emp.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Emp> getEmpListByQuery(int deptno) {
		String SQL = "SELECT * FROM emp WHERE deptno = ?";
		List<Emp> list = null;
		try {
			list = jdbcTemplate.query(
					SQL,
					new Object[] {deptno},
					new RowMapper() {
						public Object mapRow(ResultSet rs, int index) throws SQLException {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							int deptno = rs.getInt("deptno");
							Emp emp = new Emp(empno, ename, deptno);
                            SelectMain.printEmp(emp);
							return emp ;
						}
					}
			);
			
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	 
    public List<Map<String, Object>> queryForList_getListByDeptno(int deptno) {
 	   String sql = "select empno, ename, deptno from emp where deptno = ?";
 	   List<Map<String, Object>> list=null;
 	   
 	   try 
	    	{
 		 //return - java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
 		   list=jdbcTemplate.queryForList(sql,deptno);   
	    	}
 	   catch(DataAccessException e)
			{
				System.out.println("queryForList_getListByDeptno() - DataAccessException");
				e.getMessage();
				e.printStackTrace();	   
				
			}
        return list;
    }
    
    public List<Emp> getEmpListByQueryToImplement(int deptno) {
  	   String sql = "select empno, ename, deptno from emp where deptno = ?";
  	   List<Emp> list=null;
  	   
  	   try 
 	    	{
  		 //return - java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
  		   list = jdbcTemplate.query(sql,new Object[] {deptno}, new RowMapImpl());   
 	    	}
  	   catch(DataAccessException e)
 			{
 				System.out.println("queryForList_getListByDeptno() - DataAccessException");
 				e.getMessage();
 				e.printStackTrace();	   
 			}
         return list;
     }
    
    public void setEmpData(int empno, String ename, int deptno) {
    	String SQL = "INSERT INTO emp(empno, ename, deptno) VALUES(?, ?, ?)";
    	try {
			jdbcTemplate.update(SQL, new Object[] {empno, ename, deptno});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
    }	
    
    public void modifyEmpData(int nDeptno, int empno) {
    	String SQL = "UPDATE emp SET deptno = ? WHERE empno = ?";
    	try {
			jdbcTemplate.update(SQL, new Object[] {nDeptno, empno});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
    }	
}
