package com.test.xml_bean;

public class VodPlayer {
	private Movie movie;
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMovieName() {
		return movie.getName();
	}
	
	public int getPrice(String moviName) {
		return movie.getPrice();
	}
	
}
