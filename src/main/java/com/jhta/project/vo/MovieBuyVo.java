package com.jhta.project.vo;

public class MovieBuyVo {

	private FilmVo filmVo;
	private MovieImgVo movieImgVo;
	private String[] human;
	
	public FilmVo getFilmVo() {
		return filmVo;
	}
	public void setFilmVo(FilmVo filmVo) {
		this.filmVo = filmVo;
	}
	public MovieImgVo getMovieImgVo() {
		return movieImgVo;
	}
	public void setMovieImgVo(MovieImgVo movieImgVo) {
		this.movieImgVo = movieImgVo;
	}
	public String[] getHuman() {
		return human;
	}
	public void setHuman(String[] human) {
		this.human = human;
	}
}
