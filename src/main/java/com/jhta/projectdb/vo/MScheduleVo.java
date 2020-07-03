package com.jhta.projectdb.vo;

public class MScheduleVo {
	private int mScheduleNum;
	private int brInfoNum;
	private String mStartTime;
	public MScheduleVo(int mScheduleNum, int brInfoNum, String mStartTime) {
		super();
		this.mScheduleNum = mScheduleNum;
		this.brInfoNum = brInfoNum;
		this.mStartTime = mStartTime;
	}
	public MScheduleVo() {
		super();
	}
	public int getmScheduleNum() {
		return mScheduleNum;
	}
	public void setmScheduleNum(int mScheduleNum) {
		this.mScheduleNum = mScheduleNum;
	}
	public int getBrInfoNum() {
		return brInfoNum;
	}
	public void setBrInfoNum(int brInfoNum) {
		this.brInfoNum = brInfoNum;
	}
	public String getmStartTime() {
		return mStartTime;
	}
	public void setmStartTime(String mStartTime) {
		this.mStartTime = mStartTime;
	}
	
}
