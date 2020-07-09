package com.jhta.project.dao;

import java.util.HashMap;
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
	
	
	public List<AskVo> list(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".list",map);
	}
	public AskVo askGetinfo(int askNum) {
		return sqlSession.selectOne(NAMESPACE+".getinfo",askNum);
	}
	public int replyInsert(ReplyVo vo) {
		return sqlSession.insert(NAMESPACE2+".insert",vo);
	}
	public ReplyVo replyGetinfo(int askNum) {
		return sqlSession.selectOne(NAMESPACE2+".getinfo",askNum);
	}
	//답변 수정
	public int replyUpdate(ReplyVo vo) {
		return sqlSession.update(NAMESPACE2+".update",vo);
	}
	//답변상태
	public int respUpdate(int askNum) {
		return sqlSession.update(NAMESPACE+".respUpdate",askNum);
	}
	public int count() {
		return sqlSession.selectOne(NAMESPACE+".count");
	}
}









