package com.jhta.projectdb.vo;

public class BrInfoVo {
	private int brInfoNum;
	private int fileNum;
	private int theatherNum;
	public BrInfoVo(int brInfoNum, int fileNum, int theatherNum) {
		super();
		this.brInfoNum = brInfoNum;
		this.fileNum = fileNum;
		this.theatherNum = theatherNum;
	}
	public BrInfoVo() {
		super();
	}
	public int getBrInfoNum() {
		return brInfoNum;
	}
	public void setBrInfoNum(int brInfoNum) {
		this.brInfoNum = brInfoNum;
	}
	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	public int getTheatherNum() {
		return theatherNum;
	}
	public void setTheatherNum(int theatherNum) {
		this.theatherNum = theatherNum;
	}
	
}
