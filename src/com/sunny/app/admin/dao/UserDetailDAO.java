package com.sunny.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.admin.vo.UserDetailVO;

public class UserDetailDAO {
	
	public SqlSession sqlSession;
	
	public UserDetailDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public UserDetailVO userDetail(int userNumber){
		System.out.println("userDetail 메서드");
		return sqlSession.selectOne("admin.userDetail", userNumber);
	}

}
