package com.jhta.projectdb.vo;

import java.util.Date;

public class CuponVo {
	private int cuponNum;
	private String cuponStatus;
	private String cName;
	private Date cuponStart;
	private Date cuponEnd;
	private int memNum;
	private int cuponRate;
	public CuponVo(int cuponNum, String cuponStatus, String cName, Date cuponStart, Date cuponEnd, int memNum,
			int cuponRate) {
		super();
		this.cuponNum = cuponNum;
		this.cuponStatus = cuponStatus;
		this.cName = cName;
		this.cuponStart = cuponStart;
		this.cuponEnd = cuponEnd;
		this.memNum = memNum;
		this.cuponRate = cuponRate;
	}
	public CuponVo() {
		super();
	}
	public int getCuponNum() {
		return cuponNum;
	}
	public void setCuponNum(int cuponNum) {
		this.cuponNum = cuponNum;
	}
	public String getCuponStatus() {
		return cuponStatus;
	}
	public void setCuponStatus(String cuponStatus) {
		this.cuponStatus = cuponStatus;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Date getCuponStart() {
		return cuponStart;
	}
	public void setCuponStart(Date cuponStart) {
		this.cuponStart = cuponStart;
	}
	public Date getCuponEnd() {
		return cuponEnd;
	}
	public void setCuponEnd(Date cuponEnd) {
		this.cuponEnd = cuponEnd;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getCuponRate() {
		return cuponRate;
	}
	public void setCuponRate(int cuponRate) {
		this.cuponRate = cuponRate;
	}
	
}
