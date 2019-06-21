package com.test.service;

import java.util.List;

import com.test.dao.CmemberDAO;
import com.test.dto.Cmember;

public class CmemberService {

	private CmemberDAO cMemberDAO;

	public CmemberService(CmemberDAO cMemberDAO) {
		this.cMemberDAO = cMemberDAO;
	}
	
	public Integer query_getRecordNum() {
		return cMemberDAO.getRecordNum();
	}
	
	public List<String> query_getPwById(String id) {
		return cMemberDAO.getPwById(id);
	}
	
	public List<String> query_getIdByCNum(int cNum) {
		return cMemberDAO.getIdByCNum(cNum);
	}
	
	public List<Cmember> query_getDataByNameANDCNum(Cmember cmember) {
		return cMemberDAO.getDataByNameANDCNum(cmember);
	}
	
	public List<Cmember> query_getDataByPw(String pw) {
		return cMemberDAO.getDataByPw(pw);
	}
	
	public int query_setRecord(Cmember cmember) {
		return cMemberDAO.setRecord(cmember);
	}
	
	public void query_delRecordByPw(String pw) {
		cMemberDAO.delRecordByPw(pw);
	}
	
	public void query_setPwById(Cmember cmember) {
		cMemberDAO.setPwById(cmember);
	}
	
}
