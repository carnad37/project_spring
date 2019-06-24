package com.mylec.service;

import java.util.List;

import com.mylec.dao.BmemberDAO;
import com.mylec.dto.Bmember;

public class BmemberServiceImpl implements BmemberService {
	
	private BmemberDAO dao;
	
	public BmemberServiceImpl(BmemberDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String getPwById(String id) {		
		return dao.getPwById(id);
	}

	@Override
	public Bmember getDataById(String id) {
		return dao.getDataById(id);
	}

	@Override
	public List<String> getIdByName(String name) {
		return dao.getIdByName(name);
	}

	@Override
	public List<Bmember> getDataByName(String name) {
		return dao.getDataByName(name);
	}

}
