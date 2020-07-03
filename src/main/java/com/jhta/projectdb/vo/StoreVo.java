package com.jhta.projectdb.vo;

public class StoreVo {
	private int storeNum;
	private int branchNum;
	// 여기 인트 인거 확인해 볼 필요가 있음...
	private int storeName;
	private int storePrice;
	private String storeStatus;
	public StoreVo(int storeNum, int branchNum, int storeName, int storePrice, String storeStatus) {
		super();
		this.storeNum = storeNum;
		this.branchNum = branchNum;
		this.storeName = storeName;
		this.storePrice = storePrice;
		this.storeStatus = storeStatus;
	}
	public StoreVo() {
		super();
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	public int getStoreName() {
		return storeName;
	}
	public void setStoreName(int storeName) {
		this.storeName = storeName;
	}
	public int getStorePrice() {
		return storePrice;
	}
	public void setStorePrice(int storePrice) {
		this.storePrice = storePrice;
	}
	public String getStoreStatus() {
		return storeStatus;
	}
	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}
	
}
