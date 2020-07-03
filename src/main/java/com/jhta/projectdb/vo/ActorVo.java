package com.jhta.projectdb.vo;

public class ActorVo {
	private int actorNum;
	private String actorName;
	private String actorAge;
	private String actorImg;
	private String actorNation;
	public ActorVo(int actorNum, String actorName, String actorAge, String actorImg, String actorNation) {
		super();
		this.actorNum = actorNum;
		this.actorName = actorName;
		this.actorAge = actorAge;
		this.actorImg = actorImg;
		this.actorNation = actorNation;
	}
	public ActorVo() {
		super();
	}
	public int getActorNum() {
		return actorNum;
	}
	public void setActorNum(int actorNum) {
		this.actorNum = actorNum;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorAge() {
		return actorAge;
	}
	public void setActorAge(String actorAge) {
		this.actorAge = actorAge;
	}
	public String getActorImg() {
		return actorImg;
	}
	public void setActorImg(String actorImg) {
		this.actorImg = actorImg;
	}
	public String getActorNation() {
		return actorNation;
	}
	public void setActorNation(String actorNation) {
		this.actorNation = actorNation;
	}
	
	
}
