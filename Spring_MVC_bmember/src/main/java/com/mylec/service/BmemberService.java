package com.mylec.service;

import java.util.List;

import com.mylec.dto.Bmember;

public interface BmemberService {

	public String getPwById(String id);
	public Bmember getDataById(String id);
	public List<String> getIdByName(String name);
	public List<Bmember> getDataByName(String name);
	
}
