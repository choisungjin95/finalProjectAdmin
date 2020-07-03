package com.jhta.project.vo;

public class RevenueVo {
	private int revenueNum;
	private int outcome;
	private int ticketIncome;
	private int storeIncome;
	private int branchNum;
	public RevenueVo(int revenueNum, int outcome, int ticketIncome, int storeIncome, int branchNum) {
		super();
		this.revenueNum = revenueNum;
		this.outcome = outcome;
		this.ticketIncome = ticketIncome;
		this.storeIncome = storeIncome;
		this.branchNum = branchNum;
	}
	public RevenueVo() {
		super();
	}
	public int getRevenueNum() {
		return revenueNum;
	}
	public void setRevenueNum(int revenueNum) {
		this.revenueNum = revenueNum;
	}
	public int getOutcome() {
		return outcome;
	}
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}
	public int getTicketIncome() {
		return ticketIncome;
	}
	public void setTicketIncome(int ticketIncome) {
		this.ticketIncome = ticketIncome;
	}
	public int getStoreIncome() {
		return storeIncome;
	}
	public void setStoreIncome(int storeIncome) {
		this.storeIncome = storeIncome;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	
	
}
