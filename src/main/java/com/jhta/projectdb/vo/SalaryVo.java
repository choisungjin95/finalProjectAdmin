package com.jhta.projectdb.vo;

import java.util.Date;

public class SalaryVo {
	private int salNum;
	private Date salDate;
	private int salary;
	private int staffNum;
	public SalaryVo(int salNum, Date salDate, int salary, int staffNum) {
		super();
		this.salNum = salNum;
		this.salDate = salDate;
		this.salary = salary;
		this.staffNum = staffNum;
	}
	public SalaryVo() {
		super();
	}
	public int getSalNum() {
		return salNum;
	}
	public void setSalNum(int salNum) {
		this.salNum = salNum;
	}
	public Date getSalDate() {
		return salDate;
	}
	public void setSalDate(Date salDate) {
		this.salDate = salDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	
}
