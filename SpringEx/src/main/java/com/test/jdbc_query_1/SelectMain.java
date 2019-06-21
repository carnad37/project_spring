package com.test.jdbc_query_1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_select.xml");
		List<String> nameList = null;
		
		SelectService onjService = (SelectService)context.getBean("empservice");
		nameList = onjService.query_getEnameByDeptno(10);
		System.out.println(nameList);
		
		List<Emp> empList = onjService.query_getEmpListByQuery(10);
		printEmpList(empList);
		
		System.out.println("query_getEmpListByQueryForList");
		
		empList = onjService.query_getEmpListByQueryForList(10);
		printEmpList(empList);
		
		System.out.println("query_getEmpListByQueryToImplement");
		
		empList = onjService.query_getEmpListByQueryToImplement(10);
		printEmpList(empList);
		
		onjService.update_setEmpData(8774, "test", 11);

	}
	
	public static void printEmpList(List<Emp> empList) {
		for (Emp emp : empList) {
			printEmp(emp);
			System.out.println("");
		}
	}
	
	public static void printEmp(Emp emp) {
		System.out.println("empno : " + emp.getEmpno());
		System.out.println("ename : " + emp.getEname());
		System.out.println("edeptno : " + emp.getDeptno());
	}
}
