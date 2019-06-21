package com.test.dto;

public class PostData {

	private int postNum;
	private String DO;
	private String SI;
	private String streetName;
	private int houseNum;
	
	public PostData() {
		
	}

	
	
	public PostData(int postNum, String dO, String sI, String streetName, int houseNum) {
		super();
		this.postNum = postNum;
		DO = dO;
		SI = sI;
		this.streetName = streetName;
		this.houseNum = houseNum;
	}



	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getDO() {
		return DO;
	}

	public void setDO(String dO) {
		DO = dO;
	}

	public String getSI() {
		return SI;
	}

	public void setSI(String sI) {
		SI = sI;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	
		
	
	
}
