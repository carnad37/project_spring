package com.exam.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.jdbc_query_1.Emp;
import com.test.jdbc_query_1.SelectMain;

 

public class SelectDao{
     
       private JdbcTemplate jdbcTemplate;
  
		
       public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
       }
       public List<String> query_getEnameByDeptno(int deptno) {
           String sql = "select ename from emp where deptno = ?";     
           List<String> list=null;
    	   try {
    		   //<T> java.util.List<T>
    		   list = jdbcTemplate.queryForList(sql, new Object[] { deptno }, String.class);
	    	}
    	   catch(DataAccessException e)
			{
				System.out.println("query_getEnameByDeptnoByBean() - DataAccessException");
				e.getMessage();
				e.printStackTrace();	   
				
			}
           return list;
       }
       

       public List<Emp> query_getEmpByDeptnoByBean(int deptno) {
           String sql = "select empno, ename, deptno from emp where deptno = ?";     
           List<Emp> list=null;
    	   try {
    		   //<T> java.util.List<T>
    		   list = jdbcTemplate.query(sql,new Object[] { deptno }, new BeanPropertyRowMapper(Emp.class));
	    	}
    	   catch(DataAccessException e) {
				System.out.println("queryForList_getListByDeptno_SetReturnType() - DataAccessException");
				e.getMessage();
				e.printStackTrace();				
			}
           return list;
       }
       
       
       public List<Emp> query_getEmpByDeptno(int deptno) {
    	   
    	  // String sql = "select empno, ename, deptno from emp where ename =?";
             String sql = "select empno, ename, deptno from emp where deptno = ?";
                      
           List<Emp> list=null;
      	   try 
  	    	{
      		//<T> java.util.List<T>
             
             list = jdbcTemplate.query(
                           sql,
                           new Object[] { deptno },
                           new RowMapper() {
                                 public Object mapRow(ResultSet rs, int index) throws SQLException {
                                        int empno = rs.getInt("empno");
                                        String ename = rs.getString("ename");
                                        int deptno =  rs.getInt("deptno");
                                       Emp emp = new Emp(empno, ename, deptno);
                                       printEmp(emp);
                                        return  emp;                                          
                                 }
                           }
             );
             
             //list = jdbcTemplate.query(sql,new Object[] { deptno }, new RowMapperImpl());
      		 //list = jdbcTemplate.query(sql,new Object[] { "Onj"+"%'" }, new RowMapperImpl());
  	    	}
    	   catch(DataAccessException e)
			{
				System.out.println("queryForList_getListByDeptno_SetReturnType() - DataAccessException");
				e.getMessage();
				e.printStackTrace();				
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
   	public static void printEmp(Emp emp) {
		System.out.println("empno : " + emp.getEmpno());
		System.out.println("ename : " + emp.getEname());
		System.out.println("edeptno : " + emp.getDeptno());
	}
}