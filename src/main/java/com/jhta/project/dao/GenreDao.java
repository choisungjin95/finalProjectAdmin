package com.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.GenreVo;

@Repository
public class GenreDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.genre";
	
	public List<GenreVo> selectboxinfo() {
		System.out.println("dao");
		return sqlSession.selectList(NAMESPACE+".list");
	}
}
