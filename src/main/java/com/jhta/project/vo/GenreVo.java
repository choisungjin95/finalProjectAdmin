package com.jhta.project.vo;

public class GenreVo {
	private int genreNum;
	private String genreName;
	public GenreVo(int genreNum, String genreName) {
		super();
		this.genreNum = genreNum;
		this.genreName = genreName;
	}
	public GenreVo() {
		super();
	}
	public int getGenreNum() {
		return genreNum;
	}
	public void setGenreNum(int genreNum) {
		this.genreNum = genreNum;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
}
