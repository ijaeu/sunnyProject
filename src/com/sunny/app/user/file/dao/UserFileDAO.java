package com.sunny.app.user.file.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.user.file.dto.UserFileDTO;
import com.sunny.app.user.file.vo.UserFileVO;

public class UserFileDAO {

	public SqlSession sqlSession;
	
	public UserFileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(UserFileDTO userFileDTO) {
		sqlSession.insert("userFile.insert", userFileDTO);
	}
	
	public int select (int userNumber) {
		return sqlSession.selectOne("userFile.select", userNumber);
	}
	
	public UserFileVO selectFile(int userNumber) {
		return sqlSession.selectOne("userFile.selectFile", userNumber);
	}
	
	public void update(UserFileDTO userFileDTO){
		sqlSession.update("userFile.update", userFileDTO);
	}
	
	public void delete(int userNumber) {
		sqlSession.delete("userFile.delete", userNumber);
	}
}
