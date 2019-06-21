package com.test.jdbc_query_1;

import java.util.List;

public class SelectService {

	private SelectDao dao;

	public SelectService(SelectDao dao) {
		this.dao = dao;
	}
	
	public List<String> query_getEnameByDeptno(int deptno) {
		return dao.getNameList(deptno);
	}
	
	public List<Emp> query_getEmpListByQueryForList(int deptno) {
		return dao.getEmpListByQueryForList(deptno);
	}
	
	public List<Emp> query_getEmpListByQuery(int deptno) {
		return dao.getEmpListByQuery(deptno);
	}
	
	public List<Emp> query_getEmpListByQueryToImplement(int deptno) {
		return dao.getEmpListByQueryToImplement(deptno);
	}	
	
	public void update_setEmpData(int empno, String ename, int deptno) {
		dao.setEmpData(empno, ename, deptno);
	}
	
}
