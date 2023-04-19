package com.sunny.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.HeaderInfoVO;

public class AdminDAO {

	public SqlSession sqlSession;
	
	
	public AdminDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	admin 회원정보 가져오기
	public void adminSelect(int adminNumber) {
		System.out.println("amdin.adminSelect 메서드");
	}
	
//	admin login 
	public int login(AdminDTO adminDTO){
		System.out.println("amdin.login 메서드");
		Integer adminNumber = 0;
		adminNumber = sqlSession.selectOne("admin.login", adminDTO);
		if(adminNumber == null) {
			adminNumber = 0;
		}
		return adminNumber;
	 }
	
//	회원 탈퇴
	public void kill(int userNumber) {
		System.out.println("amdin.kill 메서드");
		sqlSession.delete("admin.kill", userNumber);
	}
	
//	식고수 -> 식집사 강등
	public void down(int userNumber) {
		System.out.println("amdin.down 메서드");
		sqlSession.update("admin.down", userNumber);
	}
	
//	식집사 -> 식고수 등업
	public void up(int userNumber) {
		System.out.println("amdin.up 메서드");
		sqlSession.update("admin.up", userNumber);
	}
	
	public void negative(int userNumber) {
		System.out.println("amdin.negative 메서드");
		sqlSession.update("admin.negative", userNumber);
	}
	
	public HeaderInfoVO headerInfo() {
		System.out.println("amdin.headerInfo 메서드");
		return sqlSession.selectOne("admin.headerInfo");
	}
	
	public void deleteGosuNumber(int userNumber) {
		System.out.println("amdin.deleteGosuNumber 메서드");
		sqlSession.delete("admin.deleteGosuNumber", userNumber);
	}
	
	public void deleteGosuApply(int applyNumber) {
		System.out.println("amdin.deleteGosuApply 메서드");
		sqlSession.delete("admin.deleteGosuApply", applyNumber);
	}
}
