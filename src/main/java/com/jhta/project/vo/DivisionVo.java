package com.jhta.project.vo;

public class DivisionVo {
	private int divisionNum;
	private String divisionName;
	public DivisionVo(int divisionNum, String divisionName) {
		super();
		this.divisionNum = divisionNum;
		this.divisionName = divisionName;
	}
	public DivisionVo() {
		super();
	}
	public int getDivisionNum() {
		return divisionNum;
	}
	public void setDivisionNum(int divisionNum) {
		this.divisionNum = divisionNum;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	
}
