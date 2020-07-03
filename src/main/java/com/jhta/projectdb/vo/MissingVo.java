package com.jhta.projectdb.vo;

import java.util.Date;

public class MissingVo {
	private int missNum;
	private int branchNum;
	private Date getDate;
	private Date findDate;
	private String missDetail;
	private String missTitle;
	public MissingVo(int missNum, int branchNum, Date getDate, Date findDate, String missDetail, String missTitle) {
		super();
		this.missNum = missNum;
		this.branchNum = branchNum;
		this.getDate = getDate;
		this.findDate = findDate;
		this.missDetail = missDetail;
		this.missTitle = missTitle;
	}
	public MissingVo() {
		super();
	}
	public int getMissNum() {
		return missNum;
	}
	public void setMissNum(int missNum) {
		this.missNum = missNum;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	public Date getGetDate() {
		return getDate;
	}
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}
	public Date getFindDate() {
		return findDate;
	}
	public void setFindDate(Date findDate) {
		this.findDate = findDate;
	}
	public String getMissDetail() {
		return missDetail;
	}
	public void setMissDetail(String missDetail) {
		this.missDetail = missDetail;
	}
	public String getMissTitle() {
		return missTitle;
	}
	public void setMissTitle(String missTitle) {
		this.missTitle = missTitle;
	}
	
}
