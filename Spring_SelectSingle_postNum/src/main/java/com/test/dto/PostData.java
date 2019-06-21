package com.test.dto;

public class PostData {

	private int postNum;
	private String cityDo;
	private String citySi;
	private String streetName;
	private int houseNum;
	
	public PostData() {
		// TODO Auto-generated constructor stub
	}
	
	public PostData(int postNum, String cityDo, String citySi, String streetName, int houseNum) {
		super();
		this.postNum = postNum;
		this.cityDo = cityDo;
		this.citySi = citySi;
		this.streetName = streetName;
		this.houseNum = houseNum;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getCityDo() {
		return cityDo;
	}

	public void setCityDo(String cityDo) {
		this.cityDo = cityDo;
	}

	public String getCitySi() {
		return citySi;
	}

	public void setCitySi(String citySi) {
		this.citySi = citySi;
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
