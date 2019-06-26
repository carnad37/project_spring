package com.mylec.service;

import java.util.List;

import com.mylec.dao.BmemberDAO;
import com.mylec.dto.Bmember;

public class BmemberService {

	private BmemberDAO dao;

	public BmemberService(BmemberDAO dao) {
		super();
		this.dao = dao;
	}
	
	public String getPwById(String id) {
		return dao.getPwById(id);
	}
	
	public Bmember getPwAndNameById(String id) {
		return dao.getPwAndNameById(id);
	}
	
	public List<String> getIdByName(String name) {
		return dao.getIdByName(name);
	}
	
	public List<Bmember> getIdAndPwByName(String name) {
		return dao.getIdAndPwByName(name);
	}
	
}
