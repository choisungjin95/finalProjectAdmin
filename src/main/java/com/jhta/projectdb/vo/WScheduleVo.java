package com.jhta.projectdb.vo;

import java.util.Date;

public class WScheduleVo {
	private int sNum;
	private int staffNum;
	private Date workStart;
	private Date workEnd;
	private Date workDate;
	public WScheduleVo(int sNum, int staffNum, Date workStart, Date workEnd, Date workDate) {
		super();
		this.sNum = sNum;
		this.staffNum = staffNum;
		this.workStart = workStart;
		this.workEnd = workEnd;
		this.workDate = workDate;
	}
	public WScheduleVo() {
		super();
	}
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public int getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	public Date getWorkStart() {
		return workStart;
	}
	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}
	public Date getWorkEnd() {
		return workEnd;
	}
	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	
}
