package com.test.jdbc_query_1;

public class Emp {
	private int empno;
	private String ename;
	private int deptno;
	
	public Emp() {
		
	}
	public Emp(int empno, String ename, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
