package com.jhta.project.vo;

public class BranchVo {
	private int branchNum;
	private int proNum;
	private String brName;
	private String memId;
	private String brStatus;
	private String brRegdate;
	public BranchVo(int branchNum, int proNum, String brName, String memId, String brStatus, String brRegdate) {
		super();
		this.branchNum = branchNum;
		this.proNum = proNum;
		this.brName = brName;
		this.memId = memId;
		this.brStatus = brStatus;
		this.brRegdate = brRegdate;
	}
	public BranchVo() {
		super();
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getBrStatus() {
		return brStatus;
	}
	public void setBrStatus(String brStatus) {
		this.brStatus = brStatus;
	}
	public String getBrRegdate() {
		return brRegdate;
	}
	public void setBrRegdate(String brRegdate) {
		this.brRegdate = brRegdate;
	}
}
