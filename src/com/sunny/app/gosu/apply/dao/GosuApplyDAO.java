package com.sunny.app.gosu.apply.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.gosu.apply.dto.GosuApplyDTO;

public class GosuApplyDAO {

	public SqlSession sqlSession;
	
	public GosuApplyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(GosuApplyDTO gosuApplyDTO) {
		sqlSession.insert("gosuApply.insert", gosuApplyDTO);
	}
	
	public int getSequence() {
		return sqlSession.selectOne("gosuApply.getSequence");
	}
	
	public void applying(int userNumber) {
		System.out.println("gosuApply.applying 메서드");
		sqlSession.update("gosuApply.applying", userNumber);
	}
	
}
