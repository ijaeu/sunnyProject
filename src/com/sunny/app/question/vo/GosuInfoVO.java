package com.sunny.app.question.vo;

public class GosuInfoVO {
	private int gosuNumber;
	private String userNickname;
	
	public int getGosuNumber() {
		return gosuNumber;
	}
	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	@Override
	public String toString() {
		return "GosuInfoVO [gosuNumber=" + gosuNumber + ", userNickname=" + userNickname + "]";
	}
	

}
