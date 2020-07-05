package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.ProposalVo;
@Repository
public class ProposalDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="com.jhta.mybatis.mapper.proposal";
	public List<ProposalVo> selectList(){
		List<ProposalVo> list=session.selectList(NAMESPACE+".selectList");
		System.out.println("dao:"+list);
		return list;
	}
	
	public int totalPageNum() {
		int totalPNum=session.selectOne(NAMESPACE+".pagingTotal");
		return totalPNum;
	}
	public List<ProposalVo> getRowNums() {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("start", 1);
		parameters.put("end", 10);
		return session.selectList(NAMESPACE+".selectNowPage", parameters);
	}
}
