package com.exam.select;
 

import java.util.* ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


 

public class SelectTest {
	public static void main(String[] args) throws Exception{
			List<String> listString=null;
			List<Emp> list = null;
			List<Map<String, Object>> listMap = null;
			Emp emp = null;
			ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcSelect.xml");
		 
			SelectService onjService = (SelectService)ctx.getBean("empservice");
		/*	
			//----------- multi row  -----------------             
			//query
			list = onjService.query_getEmpByDeptno(10);		
			if(list==null)
			{
				System.out.println("return error");
			}
			else
			{
				displayList("query_getEmpByDeptno()",list);
			}
			
			list = onjService.query_getEmpByDeptnoByBean(10);
			if(list==null)
			{
				System.out.println("return error");
			}
			else
			{
				displayList("query_getEmpByDeptnoByBean()",list);
			}
			 
			//queryForList
			//return - java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
			listMap = onjService.queryForList_getListByDeptno(10);
			if(list==null)
			{
				System.out.println("return error");
			}
			else
			{
				displayListTypeMap("queryForList_getListByDeptno()",listMap);
			}
        */
			
           	listString=onjService.query_getEnameByDeptno(10);
			displayListString("query_getEnameByDeptnoByBean",listString);  
      
	}
	public static void displayListString(String title, List<String> list) {
		System.out.println(" --- "+title+" --- ");
		for(String e: list) {
				System.out.println(e);
		}
	}
	public static void displayEmp(String title, Emp e) {
		System.out.println(" --- "+title+" --- ");
		System.out.println("empno : "+e.getEmpno());
		System.out.println("ename : "+e.getEname());
		System.out.println("deptno : "+e.getDeptno());        
	}
   
	public static void displayList(String title, List<Emp> list) {
		System.out.println(" --- "+title+" --- ");
//		for(Object e: list) {
//				System.out.print(((Emp)e).getEmpno());
//				System.out.print(((Emp)e).getEname());
//				System.out.println(((Emp)e).getDeptno());                  
//		}
		for (Emp emp : list) {
			displayEmp("unit_emp", emp);
		}
    }
	public static void displayListTypeMap(String title, List<Map<String, Object>> list) {
    	   System.out.println(" --- "+title+" --- ");
           for(int i=0;i<list.size();i++){

        	   Map ma=(Map)list.get(i);
        	   System.out.println(ma.values());
        	   Set<String> keys = ma.keySet();
        	   Iterator<String> it = keys.iterator();
        	   while(it.hasNext()) {
        		   String key = it.next();
        		   Object value = ma.get(key);
        		   System.out.println("key : "+key+", value : "+value);
        	   }      
		     }
     }
  
}
 