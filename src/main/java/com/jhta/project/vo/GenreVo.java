package com.jhta.project.vo;

public class GenreVo {
	private int genreNum;
	private String sffPosition;
	public GenreVo(int genreNum, String sffPosition) {
		super();
		this.genreNum = genreNum;
		this.sffPosition = sffPosition;
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
	public String getSffPosition() {
		return sffPosition;
	}
	public void setSffPosition(String sffPosition) {
		this.sffPosition = sffPosition;
	}
	
}
