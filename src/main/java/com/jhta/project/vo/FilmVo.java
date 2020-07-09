package com.jhta.project.vo;

public class FilmVo {
	private int filmNum;
	private String filmName;
	private String filmStory;
	private String filmStart;
	private String filmEnd;
	private int filmPrice;
	private String filmHead;
	private String filmStatus;
	private int genreNum;
	public FilmVo(int filmNum, String filmName, String filmStory, String filmStart, String filmEnd, int filmPrice,
			String filmHead, String filmStatus, int genreNum) {
		super();
		this.filmNum = filmNum;
		this.filmName = filmName;
		this.filmStory = filmStory;
		this.filmStart = filmStart;
		this.filmEnd = filmEnd;
		this.filmPrice = filmPrice;
		this.filmHead = filmHead;
		this.filmStatus = filmStatus;
		this.genreNum = genreNum;
	}
	public FilmVo() {
		super();
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getFilmStory() {
		return filmStory;
	}
	public void setFilmStory(String filmStory) {
		this.filmStory = filmStory;
	}
	public String getFilmStart() {
		return filmStart;
	}
	public void setFilmStart(String filmStart) {
		this.filmStart = filmStart;
	}
	public String getFilmEnd() {
		return filmEnd;
	}
	public void setFilmEnd(String filmEnd) {
		this.filmEnd = filmEnd;
	}
	public int getFilmPrice() {
		return filmPrice;
	}
	public void setFilmPrice(int filmPrice) {
		this.filmPrice = filmPrice;
	}
	public String getFilmHead() {
		return filmHead;
	}
	public void setFilmHead(String filmHead) {
		this.filmHead = filmHead;
	}
	public String getFilmStatus() {
		return filmStatus;
	}
	public void setFilmStatus(String filmStatus) {
		this.filmStatus = filmStatus;
	}
	public int getGenreNum() {
		return genreNum;
	}
	public void setGenreNum(int genreNum) {
		this.genreNum = genreNum;
	}
	
}
