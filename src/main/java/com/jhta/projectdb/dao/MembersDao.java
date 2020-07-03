package com.jhta.projectdb.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.projectdb.vo.MembersVo;

@Repository
public class MembersDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.MembersMapper";
	
	public int insert(MembersVo vo) {
		System.out.println("dao");
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
}
