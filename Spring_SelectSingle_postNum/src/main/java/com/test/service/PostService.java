package com.test.service;

import java.util.List;

import com.test.dao.PostDao;
import com.test.dto.PostData;

public class PostService {

	private PostDao postDao;
	
	public PostService(PostDao postDao) {
		this.postDao = postDao;
	}
	
	public Integer query_getMaxPostNum() {
		return postDao.getMaxPostNum();
	}
	
	public Integer query_getHouseNumByStreetName(String streetName) {
		return postDao.getHouseNumByStreetName(streetName);
	}
	
	public Integer query_getPostNumByStreetNameANDHouseNum(PostData postData) {
		return postDao.getPostNumByStreetNameANDHouseNum(postData);
	}
	
	public List<PostData> query_getPostDataByPostNum(int postNum) {
		return postDao.getPostDataByPostNum(postNum);
	}
}
