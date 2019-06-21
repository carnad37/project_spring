package com.test.dao;

import java.util.List;
import com.test.dto.PostData;

public class PostDaoImpl_Jdbc implements PostDao {

	private PostDao_jdbc dao;
		
	public PostDaoImpl_Jdbc(PostDao_jdbc dao) {
		this.dao = dao;
	}

	@Override
	public int getMaxPostNum() {
		return dao.getMaxPostNum();
	}

	@Override
	public int getHouseNumByStreetName(String streetName) {
		return dao.getHouseNumByStreetName(streetName);
	}

	@Override
	public int getPostNumByStreetNameANDHouseNum(PostData postData) {
		return dao.getPostNumByStreetNameANDHouseNum(postData.getStreetName(), postData.getHouseNum());
	}

	@Override
	public List<PostData> getPostDataByPostNum(int postNum) {
		return dao.getPostDataByPostNum(postNum);
	}
}
