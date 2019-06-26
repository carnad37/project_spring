package com.mylec.dao;

import java.util.List;

import com.mylec.dto.Bmember;

public interface BmemberDAO {
	
	public String getPwById(String id);
	
	public Bmember getPwAndNameById(String id);
	
	public List<String> getIdByName(String name);
	
	public List<Bmember> getIdAndPwByName(String name);
	
}
