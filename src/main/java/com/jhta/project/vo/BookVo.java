package com.jhta.project.vo;

public class BookVo {
	private int bookNum;
	private String bookStatus;
	private int seatNum;
	private int mScheduleNum;
	private int chargeNum;
	public BookVo(int bookNum, String bookStatus, int seatNum, int mScheduleNum, int chargeNum) {
		super();
		this.bookNum = bookNum;
		this.bookStatus = bookStatus;
		this.seatNum = seatNum;
		this.mScheduleNum = mScheduleNum;
		this.chargeNum = chargeNum;
	}
	public BookVo() {
		super();
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getmScheduleNum() {
		return mScheduleNum;
	}
	public void setmScheduleNum(int mScheduleNum) {
		this.mScheduleNum = mScheduleNum;
	}
	public int getChargeNum() {
		return chargeNum;
	}
	public void setChargeNum(int chargeNum) {
		this.chargeNum = chargeNum;
	}
	
}
