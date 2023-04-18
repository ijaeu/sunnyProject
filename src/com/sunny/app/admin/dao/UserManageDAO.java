package com.sunny.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.admin.vo.UserManageVO;

public class UserManageDAO {
	
	public SqlSession sqlSession;
	
	public UserManageDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public List<UserManageVO> userInfo(Map<String, Object> pageMap){
		System.out.println("userInfo메서드");
		return sqlSession.selectList("admin.userInfo", pageMap);	
	}

	public int getTotal() {
		return sqlSession.selectOne("admin.getTotal");
	}
}
