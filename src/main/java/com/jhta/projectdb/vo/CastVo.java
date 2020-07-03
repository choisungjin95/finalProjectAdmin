package com.jhta.projectdb.vo;

public class CastVo {
	private int castNum;
	private int actorNum;
	private int filmNum;
	public CastVo(int castNum, int actorNum, int filmNum) {
		super();
		this.castNum = castNum;
		this.actorNum = actorNum;
		this.filmNum = filmNum;
	}
	public CastVo() {
		super();
	}
	public int getCastNum() {
		return castNum;
	}
	public void setCastNum(int castNum) {
		this.castNum = castNum;
	}
	public int getActorNum() {
		return actorNum;
	}
	public void setActorNum(int actorNum) {
		this.actorNum = actorNum;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	
}
