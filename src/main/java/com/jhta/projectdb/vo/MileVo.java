package com.jhta.projectdb.vo;

import java.util.Date;

public class MileVo {
	private int mileNum;
	private Date mileDate;
	private int mile;
	private int memNum;
	public MileVo(int mileNum, Date mileDate, int mile, int memNum) {
		super();
		this.mileNum = mileNum;
		this.mileDate = mileDate;
		this.mile = mile;
		this.memNum = memNum;
	}
	public MileVo() {
		super();
	}
	public int getMileNum() {
		return mileNum;
	}
	public void setMileNum(int mileNum) {
		this.mileNum = mileNum;
	}
	public Date getMileDate() {
		return mileDate;
	}
	public void setMileDate(Date mileDate) {
		this.mileDate = mileDate;
	}
	public int getMile() {
		return mile;
	}
	public void setMile(int mile) {
		this.mile = mile;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
}
