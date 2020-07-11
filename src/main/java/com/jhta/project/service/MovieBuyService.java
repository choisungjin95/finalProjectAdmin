package com.jhta.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.project.dao.CastDao;
import com.jhta.project.dao.FilmDao;
import com.jhta.project.dao.MovieImgDao;
import com.jhta.project.vo.CastVo;
import com.jhta.project.vo.FilmVo;
import com.jhta.project.vo.MovieImgVo;

@Service
public class MovieBuyService {
	@Autowired
	private FilmDao fdao;
	@Autowired
	private MovieImgDao mdao;
	@Autowired
	private CastDao cdao;
	
	@Transactional
	public int moviebuyservice(FilmVo fvo,MovieImgVo mvo,String[] name) {
		
		fdao.moviebuy(fvo);
		System.out.println("film");
		mdao.moviebuy(mvo);
		System.out.println("img");
		for(int i=0;i<name.length;i++) {
			CastVo cvo=new CastVo(0, name[i], 0);
			cdao.moviebuy(cvo);
			System.out.println("cast");
		}
		
		return 1;
	}
	
}
