package com.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.AskVo;
import com.jhta.project.vo.ReplyVo;

@Repository
public class AskDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.ask";
	private final String NAMESPACE2="com.jhta.mybatis.mapper.reply";
	
	
	public List<AskVo> list(){
		return sqlSession.selectList(NAMESPACE+".list");
	}
	public AskVo getinfo(int askNum) {
		return sqlSession.selectOne(NAMESPACE+".getinfo",askNum);
	}
	public int replyInsert(ReplyVo vo) {
		return sqlSession.insert(NAMESPACE2+".insert", vo);
	}
	
}









