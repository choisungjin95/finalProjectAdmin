package com.jhta.projectdb.vo;

public class MovieImgVo {
	private int movieImgnum;
	private String fileName;
	private String savedFileName;
	private int filmNum;
	public MovieImgVo(int movieImgnum, String fileName, String savedFileName, int filmNum) {
		super();
		this.movieImgnum = movieImgnum;
		this.fileName = fileName;
		this.savedFileName = savedFileName;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	
	
}
