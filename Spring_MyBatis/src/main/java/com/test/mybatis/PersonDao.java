package com.test.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface PersonDao {
	
    public SqlSession getSession() ;
	public void setSession(SqlSession session) ;
    public  List<Person> selectAll();
 
    public Person selectById(int id);  
    public int insert(Person person);  
    public void update(Person person);
    public void delete(int id);
    
    public List<Person> selelctCondition(int id);
    public List<Person> selectLike(String cond);
    public List<Map<String, Object>> selectAllMapResult();
    public List<Map<String, Object>> selectMapParaMapResult(Map<String, Object> mapParam);
       
}
