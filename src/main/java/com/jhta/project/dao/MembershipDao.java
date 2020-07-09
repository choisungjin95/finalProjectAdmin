package com.jhta.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="com.jhta.mybatis.mapper.membership";
	
	public String getEmail(String memId) {
		System.out.println("####memberDao≈∏±‚######");
		return session.selectOne(NAMESPACE+".getEmail", memId);
	}
}
