package com.jhta.project.vo;

public class SeatVo {
	private int seatNum;
	private int theatherNum;
	private int seatX;
	private int seatY;
	private int seatSale;
	public SeatVo(int seatNum, int theatherNum, int seatX, int seatY, int seatSale) {
		super();
		this.seatNum = seatNum;
		this.theatherNum = theatherNum;
		this.seatX = seatX;
		this.seatY = seatY;
		this.seatSale = seatSale;
	}
	public SeatVo() {
		super();
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getTheatherNum() {
		return theatherNum;
	}
	public void setTheatherNum(int theatherNum) {
		this.theatherNum = theatherNum;
	}
	public int getSeatX() {
		return seatX;
	}
	public void setSeatX(int seatX) {
		this.seatX = seatX;
	}
	public int getSeatY() {
		return seatY;
	}
	public void setSeatY(int seatY) {
		this.seatY = seatY;
	}
	public int getSeatSale() {
		return seatSale;
	}
	public void setSeatSale(int seatSale) {
		this.seatSale = seatSale;
	}
	
}
