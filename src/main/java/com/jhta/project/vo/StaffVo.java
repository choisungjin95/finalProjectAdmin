package com.jhta.project.vo;

public class StaffVo {
	private int staffNum;
	private int sffNum;
	private int divisionNum;
	private String sffName;
	private String sffAge;
	private String sffAddr;
	private String jumin;
	private String gender;
	private int accountNum;
	private String sffStatus;
	private int branchNum;
	public StaffVo(int staffNum, int sffNum, int divisionNum, String sffName, String sffAge, String sffAddr,
			String jumin, String gender, int accountNum, String sffStatus, int branchNum) {
		super();
		this.staffNum = staffNum;
		this.sffNum = sffNum;
		this.divisionNum = divisionNum;
		this.sffName = sffName;
		this.sffAge = sffAge;
		this.sffAddr = sffAddr;
		this.jumin = jumin;
		this.gender = gender;
		this.accountNum = accountNum;
		this.sffStatus = sffStatus;
		this.branchNum = branchNum;
	}
	public StaffVo() {
		super();
	}
	public int getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	public int getSffNum() {
		return sffNum;
	}
	public void setSffNum(int sffNum) {
		this.sffNum = sffNum;
	}
	public int getDivisionNum() {
		return divisionNum;
	}
	public void setDivisionNum(int divisionNum) {
		this.divisionNum = divisionNum;
	}
	public String getSffName() {
		return sffName;
	}
	public void setSffName(String sffName) {
		this.sffName = sffName;
	}
	public String getSffAge() {
		return sffAge;
	}
	public void setSffAge(String sffAge) {
		this.sffAge = sffAge;
	}
	public String getSffAddr() {
		return sffAddr;
	}
	public void setSffAddr(String sffAddr) {
		this.sffAddr = sffAddr;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getSffStatus() {
		return sffStatus;
	}
	public void setSffStatus(String sffStatus) {
		this.sffStatus = sffStatus;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	
}
