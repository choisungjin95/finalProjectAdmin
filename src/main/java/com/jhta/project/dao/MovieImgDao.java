package com.jhta.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.FilmVo;
import com.jhta.project.vo.MovieImgVo;

@Repository
public class MovieImgDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.movieImg";
	
	public int moviebuy(MovieImgVo vo) {
		System.out.println("dao");
		return sqlSession.insert(NAMESPACE+".moviebuy",vo);
	}
}
