package com.sunny.app.admin.vo;

public class GosuApplicationVO {
	
	int applyNumber;
	String userNickname;
	String applyTitle;
	String applyDate;
	
	public int getApplyNumber() {
		return applyNumber;
	}
	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
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
		return "GosuApplicationVO [applyNumber=" + applyNumber + ", userNickname=" + userNickname + ", applyTitle="
				+ applyTitle + ", applyDate=" + applyDate + "]";
	}
	
	

	
	
	
	
}
