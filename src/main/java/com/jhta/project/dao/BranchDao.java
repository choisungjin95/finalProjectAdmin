package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.BranchVo;

@Repository
public class BranchDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPAME="com.jhta.mybatis.mapper.branch";
	public List<BranchVo> list(HashMap<String,Object> map){
		return sqlSession.selectList(NAMESPAME+".list", map);
	}
	public int count() {
		return sqlSession.selectOne(NAMESPAME+".count");
	}

}
