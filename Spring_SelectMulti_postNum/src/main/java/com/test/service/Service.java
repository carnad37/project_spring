package com.test.service;

import java.util.List;

import com.test.dao.PostDAO;
import com.test.dto.PostData;

public class Service {
	
	private PostDAO dao;

	public Service(PostDAO dao) {
		super();
		this.dao = dao;
	}
	
	public void query_qfl_getByPostNum(int postNum) {
		List<PostData> postList = dao.getByPostNum(postNum);
		for (PostData postData : postList) {
			System.out.println(postData.getPostNum());
			System.out.println(postData.getDO());
			System.out.println(postData.getSI());

			System.out.println(postData.getStreetName());
		}
	}

}
