package com.test.dao;

import java.util.List;

import com.test.dto.Cmember;

public interface CmemberDAO {

	public List<Cmember> getByIdStartWord(String idStartWord);
	public List<Cmember> getByOvercNum(int cNum);
	public List<Cmember> getByNameLast(String nameLast);
	public List<Cmember> getByPWStartWord(String pwStartWord);
	
}
