package com.jhta.projectdb.vo;

public class QnaVo {
	private int qnaNum;
	private String qnaTitle;
	private String qnaContent;
	public QnaVo(int qnaNum, String qnaTitle, String qnaContent) {
		super();
		this.qnaNum = qnaNum;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
	}
	public QnaVo() {
		super();
	}
	public int getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	
}
