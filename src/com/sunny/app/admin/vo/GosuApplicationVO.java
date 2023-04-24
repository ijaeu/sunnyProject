package com.sunny.app.admin.vo;

public class GosuApplicationVO {
	
	private int applyNumber;
	private int userNumber;
	private String userNickname;
	private String applyTitle;
	private String applyDate;
	
	public int getApplyNumber() {
		return applyNumber;
	}
	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getApplyTitle() {
		return applyTitle;
	}
	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	@Override
	public String toString() {
		return "GosuApplicationVO [applyNumber=" + applyNumber + ", userNumber=" + userNumber + ", userNickname="
				+ userNickname + ", applyTitle=" + applyTitle + ", applyDate=" + applyDate + "]";
	}
	
	
	
	

	
	
	
	
}
