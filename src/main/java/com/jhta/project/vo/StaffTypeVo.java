package com.jhta.project.vo;

public class StaffTypeVo {
	private int sffNum;
	private String sffPosition;
	private int wage;
	public StaffTypeVo(int sffNum, String sffPosition, int wage) {
		super();
		this.sffNum = sffNum;
		this.sffPosition = sffPosition;
		this.wage = wage;
	}
	public StaffTypeVo() {
		super();
	}
	public int getSffNum() {
		return sffNum;
	}
	public void setSffNum(int sffNum) {
		this.sffNum = sffNum;
	}
	public String getSffPosition() {
		return sffPosition;
	}
	public void setSffPosition(String sffPosition) {
		this.sffPosition = sffPosition;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	
}
