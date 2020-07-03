package com.jhta.projectdb.vo;

public class TotalVo {
	private int totalNum;
	private int totalPeople;
	private int totalPrive;
	private int filmNum;
	public TotalVo(int totalNum, int totalPeople, int totalPrive, int filmNum) {
		super();
		this.totalNum = totalNum;
		this.totalPeople = totalPeople;
		this.totalPrive = totalPrive;
		this.filmNum = filmNum;
	}
	public TotalVo() {
		super();
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(int totalPeople) {
		this.totalPeople = totalPeople;
	}
	public int getTotalPrive() {
		return totalPrive;
	}
	public void setTotalPrive(int totalPrive) {
		this.totalPrive = totalPrive;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	
}
