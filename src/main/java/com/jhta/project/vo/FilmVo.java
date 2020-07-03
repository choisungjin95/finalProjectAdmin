package com.jhta.project.vo;

import java.util.Date;

public class FilmVo {
	private int filmNum;
	private String filmName;
	private String filmStory;
	private Date filmStart;
	private Date filmEnd;
	private int filmPrice;
	private String runnigTime;
	private String filmStatus;
	private int genreNum;
	public FilmVo(int filmNum, String filmName, String filmStory, Date filmStart, Date filmEnd, int filmPrice,
			String runnigTime, String filmStatus, int genreNum) {
		super();
		this.filmNum = filmNum;
		this.filmName = filmName;
		this.filmStory = filmStory;
		this.filmStart = filmStart;
		this.filmEnd = filmEnd;
		this.filmPrice = filmPrice;
		this.runnigTime = runnigTime;
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
	public Date getFilmStart() {
		return filmStart;
	}
	public void setFilmStart(Date filmStart) {
		this.filmStart = filmStart;
	}
	public Date getFilmEnd() {
		return filmEnd;
	}
	public void setFilmEnd(Date filmEnd) {
		this.filmEnd = filmEnd;
	}
	public int getFilmPrice() {
		return filmPrice;
	}
	public void setFilmPrice(int filmPrice) {
		this.filmPrice = filmPrice;
	}
	public String getRunnigTime() {
		return runnigTime;
	}
	public void setRunnigTime(String runnigTime) {
		this.runnigTime = runnigTime;
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
