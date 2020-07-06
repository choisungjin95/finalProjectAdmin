package com.jhta.project.vo;

import java.util.Date;

public class AskVo {
	private int askNum;
	private int memNum;
	private String qnaTitle;
	private String askContent;
	private Date askRegdate;
	private String memId;
	private String response;
	private String email;
	
	public AskVo() {}

	public AskVo(int askNum, int memNum, String qnaTitle, String askContent, Date askRegdate, String memId,
			String response, String email) {
		super();
		this.askNum = askNum;
		this.memNum = memNum;
		this.qnaTitle = qnaTitle;
		this.askContent = askContent;
		this.askRegdate = askRegdate;
		this.memId = memId;
		this.response = response;
		this.email = email;
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

	public Date getAskRegdate() {
		return askRegdate;
	}

	public void setAskRegdate(Date askRegdate) {
		this.askRegdate = askRegdate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
