package com.jhta.project.vo;

public class MovieImgVo {
	private int movieImgnum;
	private String movieImgUrl;
	private int filmNum;
	public MovieImgVo(int movieImgnum, String movieImgUrl, int filmNum) {
		super();
		this.movieImgnum = movieImgnum;
		this.movieImgUrl = movieImgUrl;
		this.filmNum = filmNum;
	}
	public MovieImgVo() {
		super();
	}
	public int getMovieImgnum() {
		return movieImgnum;
	}
	public void setMovieImgnum(int movieImgnum) {
		this.movieImgnum = movieImgnum;
	}
	public String getMovieImgUrl() {
		return movieImgUrl;
	}
	public void setMovieImgUrl(String movieImgUrl) {
		this.movieImgUrl = movieImgUrl;
	}
		public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	
	
}
