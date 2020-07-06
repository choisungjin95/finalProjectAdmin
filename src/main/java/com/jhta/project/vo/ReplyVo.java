package com.jhta.project.vo;

public class ReplyVo {
	private int replyNum;
	private String staffId;
	private String qnaTitle;
	private String replyContent;
	private String replyRegdate;
	private int askNum;
	
	public ReplyVo() {
		super();
	}

	public ReplyVo(int replyNum, String staffId, String qnaTitle, String replyContent, String replyRegdate,
			int askNum) {
		super();
		this.replyNum = replyNum;
		this.staffId = staffId;
		this.qnaTitle = qnaTitle;
		this.replyContent = replyContent;
		this.replyRegdate = replyRegdate;
		this.askNum = askNum;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyRegdate() {
		return replyRegdate;
	}

	public void setReplyRegdate(String replyRegdate) {
		this.replyRegdate = replyRegdate;
	}

	public int getAskNum() {
		return askNum;
	}

	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	
}
