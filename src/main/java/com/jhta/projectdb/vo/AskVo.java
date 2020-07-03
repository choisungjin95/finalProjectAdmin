package com.jhta.projectdb.vo;

public class AskVo {
	private int askNum;
	private int memNum;
	private String qnaTitle;
	private String askContent;
	private String askRegdate;
	public AskVo(int askNum, int memNum, String qnaTitle, String askContent, String askRegdate) {
		super();
		this.askNum = askNum;
		this.memNum = memNum;
		this.qnaTitle = qnaTitle;
		this.askContent = askContent;
		this.askRegdate = askRegdate;
	}
	public AskVo() {
		super();
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getAskContent() {
		return askContent;
	}
	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}
	public String getAskRegdate() {
		return askRegdate;
	}
	public void setAskRegdate(String askRegdate) {
		this.askRegdate = askRegdate;
	}
	
}
