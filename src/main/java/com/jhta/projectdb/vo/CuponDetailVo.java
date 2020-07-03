package com.jhta.projectdb.vo;

public class CuponDetailVo {
	private int cDetailNum;
	private String cArea;
	private String ableDate;
	private int cuponNum;
	public CuponDetailVo(int cDetailNum, String cArea, String ableDate, int cuponNum) {
		super();
		this.cDetailNum = cDetailNum;
		this.cArea = cArea;
		this.ableDate = ableDate;
		this.cuponNum = cuponNum;
	}
	public CuponDetailVo() {
		super();
	}
	public int getcDetailNum() {
		return cDetailNum;
	}
	public void setcDetailNum(int cDetailNum) {
		this.cDetailNum = cDetailNum;
	}
	public String getcArea() {
		return cArea;
	}
	public void setcArea(String cArea) {
		this.cArea = cArea;
	}
	public String getAbleDate() {
		return ableDate;
	}
	public void setAbleDate(String ableDate) {
		this.ableDate = ableDate;
	}
	public int getCuponNum() {
		return cuponNum;
	}
	public void setCuponNum(int cuponNum) {
		this.cuponNum = cuponNum;
	}
	
}
