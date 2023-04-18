package com.sunny.app.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.find.password.dto.FindPasswordDTO;
import com.sunny.app.story.file.vo.StoryFileVO;
import com.sunny.app.user.dto.UserDTO;
import com.sunny.app.user.vo.UserVO;

public class UserDAO {

	public SqlSession sqlSession;
	
	public UserDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public String getUserId1(int userNumber) {
		return sqlSession.selectOne("user.getUserId1", userNumber);
	}

	public void join(UserDTO userDTO) {
		sqlSession.insert("user.join", userDTO);
		System.out.println("join메서드");
	}
	
	public void insertFindPassword(FindPasswordDTO findPasswordDTO) {
		sqlSession.insert("findPassword.insertFindPassword", findPasswordDTO);
		System.out.println("insertfindpassword메서드");
	}
	
	public int login(UserDTO userDTO) {
		return sqlSession.selectOne("user.login", userDTO);
	}
	
	public boolean checkId(String userId) {
		return (Integer)sqlSession.selectOne("user.checkId", userId) < 1;
	}
	
	public String getUserId(int userNumber) {
		return sqlSession.selectOne("user.getUserId", userNumber);
	}
	
	public UserVO getUserInfo(int userNumber) {
		return sqlSession.selectOne("user.getUserInfo", userNumber);
	}
	
	public void userModify(UserVO userVO) {
		sqlSession.update("user.userModify", userVO);
	}
	
	public void userComment(UserDTO userDTO) {
		sqlSession.update("user.userComment", userDTO);
	}
	
	public void userDrop(int userNumber) {
		sqlSession.delete("user.userDrop", userNumber);
	}
	
	public String getMemberId(int userNumber) {
		return sqlSession.selectOne("user.getMemberId", userNumber);
	}
	
	public List<StoryFileVO> myStoryList(int userNumber){
		return sqlSession.selectList("user.myStoryList", userNumber);
	}
	
	public int myStoryCnt(int userNumber) {
		return sqlSession.selectOne("user.myStoryCnt", userNumber);
	}
	
//	회원정보수정에서 비밀번호 확인
	public boolean checkPw(UserDTO userDTO) {
		return (Integer)sqlSession.selectOne("user.checkPw", userDTO) < 1;
	}
//	회원정보수정에서 닉네임 중복확인
	public boolean checkNick(String userNickname) {
		return (Integer)sqlSession.selectOne("user.checkNick", userNickname)<1;
	}
}
