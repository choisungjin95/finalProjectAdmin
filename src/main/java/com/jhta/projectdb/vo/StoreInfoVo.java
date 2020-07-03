package com.jhta.projectdb.vo;

import java.util.Date;

public class StoreInfoVo {
	private int storeInfoNum;
	private int memNum;
	private int storeNum;
	private Date buyRegdate;
	private Date usedMoment;
	public StoreInfoVo(int storeInfoNum, int memNum, int storeNum, Date buyRegdate, Date usedMoment) {
		super();
		this.storeInfoNum = storeInfoNum;
		this.memNum = memNum;
		this.storeNum = storeNum;
		this.buyRegdate = buyRegdate;
		this.usedMoment = usedMoment;
	}
	public StoreInfoVo() {
		super();
	}
	public int getStoreInfoNum() {
		return storeInfoNum;
	}
	public void setStoreInfoNum(int storeInfoNum) {
		this.storeInfoNum = storeInfoNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public Date getBuyRegdate() {
		return buyRegdate;
	}
	public void setBuyRegdate(Date buyRegdate) {
		this.buyRegdate = buyRegdate;
	}
	public Date getUsedMoment() {
		return usedMoment;
	}
	public void setUsedMoment(Date usedMoment) {
		this.usedMoment = usedMoment;
	}
	
}
