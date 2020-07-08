package com.jhta.project.vo;

public class CastVo {
	private int castNum;
	private int filmNum;
	private String name;
	public CastVo(int castNum, String name, int filmNum) {
		super();
		this.castNum = castNum;
		this.filmNum = filmNum;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setActorNum(String name) {
		this.name = name;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	
}
