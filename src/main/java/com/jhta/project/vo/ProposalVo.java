package com.jhta.project.vo;

import java.util.Date;

public class ProposalVo {
	private int proNum;
	private String memberId;
	private String proAddr;
	private String proGoal;
	private String proScale;
	private String proStatus;
	private Date proRegdate;
	public ProposalVo(int proNum, String memberId, String proAddr, String proGoal, String proScale, String proStatus,
			Date proRegdate) {
		super();
		this.proNum = proNum;
		this.memberId = memberId;
		this.proAddr = proAddr;
		this.proGoal = proGoal;
		this.proScale = proScale;
		this.proStatus = proStatus;
		this.proRegdate = proRegdate;
	}
	public ProposalVo() {
		super();
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProAddr() {
		return proAddr;
	}
	public void setProAddr(String proAddr) {
		this.proAddr = proAddr;
	}
	public String getProGoal() {
		return proGoal;
	}
	public void setProGoal(String proGoal) {
		this.proGoal = proGoal;
	}
	public String getProScale() {
		return proScale;
	}
	public void setProScale(String proScale) {
		this.proScale = proScale;
	}
	public String getProStatus() {
		return proStatus;
	}
	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}
	public Date getProRegdate() {
		return proRegdate;
	}
	public void setProRegdate(Date proRegdate) {
		this.proRegdate = proRegdate;
	}
	@Override
	public String toString() {
		return "ProposalVo [proNum=" + proNum + ", memberId=" + memberId + ", proAddr=" + proAddr + ", proGoal="
				+ proGoal + ", proScale=" + proScale + ", proStatus=" + proStatus + ", proRegdate=" + proRegdate + "]";
	}
	
}
