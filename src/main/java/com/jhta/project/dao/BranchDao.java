package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.BranchVo;
import com.jhta.project.vo.ProposalVo;

@Repository
public class BranchDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.branch";
	public List<BranchVo> list(HashMap<String,Object> map){
		return sqlSession.selectList(NAMESPACE+".list", map);
	}
	public int count(HashMap<String,Object> map) {
		return sqlSession.selectOne(NAMESPACE+".count", map);
	}
	
	//승인버튼 누르면 트랜잭션 적용되는 함수 (proposal은 update/ branch는 insert처리됨)
	public int appProposalNBranch(BranchVo brVo) {
		System.out.println("braDao"+brVo);
		return sqlSession.insert(NAMESPACE+".insert",brVo);
	}

}
