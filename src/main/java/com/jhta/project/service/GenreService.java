package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.GenreDao;
import com.jhta.project.vo.GenreVo;

@Service
public class GenreService {
	@Autowired
	private GenreDao dao;
	
	public List<GenreVo> selectboxinfo() {
		System.out.println("service");
		return dao.selectboxinfo();
	}
	
	
}
