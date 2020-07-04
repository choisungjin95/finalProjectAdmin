package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.QnaVo;

@Repository
public class QnaDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="com.jhta.mybatis.mapper.qna";
	
	public QnaVo getinfo(int qnaNum) {
		return session.selectOne(NAMESPACE+".getinfo",qnaNum);
	}
	
	public int insert(QnaVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<QnaVo> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
	
	public int update(QnaVo vo) {
		return session.update(NAMESPACE+".update",vo);
	}
	
	public int delete(int qnaNum) {
		return session.delete(NAMESPACE+".delete",qnaNum);
	}
	
	public int count() {
		return session.selectOne(NAMESPACE+".count");
	}
}
