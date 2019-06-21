package com.test.dao;

import java.util.List;

import com.test.dto.PostData;

public interface PostDao {
	
	public int getMaxPostNum();
	
	public int getHouseNumByStreetName(String streetName);
	
	public int getPostNumByStreetNameANDHouseNum(PostData postData);
	
	public List<PostData> getPostDataByPostNum(int postNum);	
}
