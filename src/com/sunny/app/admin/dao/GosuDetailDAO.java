package com.sunny.app.admin.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.admin.vo.GosuDetailVO;

public class GosuDetailDAO {

	public SqlSession sqlSession;
	
	public GosuDetailDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public GosuDetailVO gosuDetail(int userNumber) {
		System.out.println("gosuDetail 메서드");
		return sqlSession.selectOne("admin.gosuDetail", userNumber);
	}
}
