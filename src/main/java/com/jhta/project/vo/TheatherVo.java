package com.jhta.project.vo;

public class TheatherVo {
	private int theatherNum;
	private int branchNum;
	private String theatherName;
	public TheatherVo(int theatherNum, int branchNum, String theatherName) {
		super();
		this.theatherNum = theatherNum;
		this.branchNum = branchNum;
		this.theatherName = theatherName;
	}
	public TheatherVo() {
		super();
	}
	public int getTheatherNum() {
		return theatherNum;
	}
	public void setTheatherNum(int theatherNum) {
		this.theatherNum = theatherNum;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	public String getTheatherName() {
		return theatherName;
	}
	public void setTheatherName(String theatherName) {
		this.theatherName = theatherName;
	}
	
}
