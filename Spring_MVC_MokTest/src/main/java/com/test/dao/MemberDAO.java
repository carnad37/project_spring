package com.test.dao;

import com.test.dto.Member;

public interface MemberDAO {

	Member selectById(String id);
	void insert(Member member);
	
}
