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
	
	public int totalRowNum() {
		int totalRowNum=session.selectOne(NAMESPACE+".count");
		return totalRowNum;
	}
	
	public ProposalVo getinfo(int proNum){
		return session.selectOne(NAMESPACE+".getinfo",proNum);
	}
	
	//startPageRow~ endPageRow 
	public List<ProposalVo> getRowNums(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".selectNowPage", map);
	}
	//게시판 상세에서 다음글 불러오는 함수
	public ProposalVo getNextTitle(int proNum) {
		return session.selectOne(NAMESPACE+".nextTitle",proNum);
	}
	//게시판 상세에서 이전글 불러오는 함수
	public ProposalVo getPreTitle(int proNum) {
		return session.selectOne(NAMESPACE+".preTitle",proNum);
	}
	//게시판 상세에서 반려버튼 누르면 실행되는 함수
	public int rejectProposal(int proNum) {
		return session.update(NAMESPACE+".rejectProposal",proNum);
	}
	//게시판 상세에서 승인버튼 누르면 실행되는 함수
	public int approveProposal(int proNum) {
		System.out.println("dao타기");
		return session.update(NAMESPACE+".approveProposal",proNum);
	}
	
}
