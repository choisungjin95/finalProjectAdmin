package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.branch";
	
	public List<String> getName(){
		return sqlSession.selectList(NAMESPACE+".getName");
	}
	
	public List<HashMap<String, Object>> getChat(String brName){
		return sqlSession.selectList(NAMESPACE+".getChat",brName);
	}
}
