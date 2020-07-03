package com.jhta.project.vo;

import java.util.Date;

public class MembershipVo {
	private int memNum;
	private String memName;
	private String memId;
	private String memPwd;
	private String memPhone;
	private String birth;
	private String email;
	private String grade;
	private Date memRegdate;
	private int money;
	public MembershipVo(int memNum, String memName, String memId, String memPwd, String memPhone, String birth,
			String email, String grade, Date memRegdate, int money) {
		super();
		this.memNum = memNum;
		this.memName = memName;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memPhone = memPhone;
		this.birth = birth;
		this.email = email;
		this.grade = grade;
		this.memRegdate = memRegdate;
		this.money = money;
	}
	public MembershipVo() {
		super();
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getMemRegdate() {
		return memRegdate;
	}
	public void setMemRegdate(Date memRegdate) {
		this.memRegdate = memRegdate;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
