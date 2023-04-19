package com.sunny.app.find.password.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.user.dto.UserDTO;
import com.sunny.app.user.vo.UserVO;

public class FindPasswordDAO {

	public SqlSession sqlSession;
	
	
	public FindPasswordDAO() {
		
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	public int findPassword(UserVO userVO) {
//		System.out.println("findpassword 메서드");
//		return sqlSession.selectOne("findPassword.findPassword", userVO);
//	}
	
	public int findPassword(UserVO userVO) {
	    System.out.println("findpassword 메서드");
	    Integer result = sqlSession.selectOne("findPassword.findPassword", userVO);
	    return (result != null) ? result.intValue() : 0;
	}
	
	public void updatePassword(UserDTO userDTO) {
		sqlSession.insert("findPassword.updatePassword", userDTO);
		System.out.println("updatePassword메서드");
	}
	
	
}

