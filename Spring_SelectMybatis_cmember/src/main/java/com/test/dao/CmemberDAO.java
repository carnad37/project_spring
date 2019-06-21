package com.test.dao;

import java.util.List;

import com.test.dto.Cmember;

public interface CmemberDAO {
	
	public Integer getRecordNum();
	
	public List<String> getPwById(String id);
	
	public List<String> getIdByCNum(int cNum);
	
	public List<Cmember> getDataByNameANDCNum(Cmember cmember);
	
	public int setRecord(Cmember cmember);
	
	public void delRecordByPw(String pw);
	
	public void setPwById(Cmember cmember);
	
	public List<Cmember> getDataByPw(String pw);
	
}
