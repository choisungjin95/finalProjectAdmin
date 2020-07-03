package com.jhta.project.vo;

import java.util.Date;

public class ChargeVo {
	private int chargeNum;
	private int memNum;
	private int cDetailNum;
	private String payment;
	private String memStatus;
	private Date chRegdate;
	private int bookNum;
	private String phone;
	public ChargeVo(int chargeNum, int memNum, int cDetailNum, String payment, String memStatus, Date chRegdate,
			int bookNum, String phone) {
		super();
		this.chargeNum = chargeNum;
		this.memNum = memNum;
		this.cDetailNum = cDetailNum;
		this.payment = payment;
		this.memStatus = memStatus;
		this.chRegdate = chRegdate;
		this.bookNum = bookNum;
		this.phone = phone;
	}
	public ChargeVo() {
		super();
	}
	public int getChargeNum() {
		return chargeNum;
	}
	public void setChargeNum(int chargeNum) {
		this.chargeNum = chargeNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getcDetailNum() {
		return cDetailNum;
	}
	public void setcDetailNum(int cDetailNum) {
		this.cDetailNum = cDetailNum;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}
	public Date getChRegdate() {
		return chRegdate;
	}
	public void setChRegdate(Date chRegdate) {
		this.chRegdate = chRegdate;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
