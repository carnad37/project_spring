package com.test.select;

import java.util.List;

public class CmemberService {

	private CmemberDao cDao;
	
	public CmemberService(CmemberDao cDao) {
		super();
		this.cDao = cDao;
	}

	public int query_getCountRecord() {
		return cDao.getCountRecord();
	}
	
	public List<String> query_getPwOfId(String id) {
		return cDao.getPwOfId(id); 
	}
	
	public List<String> query_getIdOfcNum(int cNum) {
		return cDao.getIdOfcNum(cNum);
	}
	
	public List<Cmember> query_getRecordByNameAndCNum(String name, int cNum) {
		return cDao.getRecordByNameAndCNum(name, cNum);
	}

	public List<Cmember> query_getRecordByPw(String pw) {
		return cDao.getRecordByPw(pw);
	}
	
	public void query_setRecord(List<Cmember> memberList) {
		cDao.setRecord(memberList);
	}
	
	public void query_delRecordByName(String name) {
		cDao.delRecordByName(name);
	}
	
	public void query_updateRecordById(String id, String nPw) {
		cDao.updateRecordById(id, nPw);
	}
}
