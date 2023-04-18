package com.sunny.app.admin.vo;

public class GosuApplicationReadVO {
	
	private int userNumber;
	private int applyNumber;
	private int gosuNumber;
	private String userNickname;
	private String applyTitle;
	private String applyDate;
	private String applyContent;
	private String gosuFieldNames;
	
	public int getUserNumber() {
		return userNumber;
	}

	public int getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
	}

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

	public String getApplyContent() {
		return applyContent;
	}

	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}

	public String getGosuFieldNames() {
		return gosuFieldNames;
	}

	public void setGosuFieldNames(String gosuFieldNames) {
		this.gosuFieldNames = gosuFieldNames;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return "GosuApplicationReadVO [userNumber=" + userNumber + ", applyNumber=" + applyNumber + ", gosuNumber="
				+ gosuNumber + ", userNickname=" + userNickname + ", applyTitle=" + applyTitle + ", applyDate="
				+ applyDate + ", applyContent=" + applyContent + ", gosuFieldNames=" + gosuFieldNames + "]";
	}
	
	
	
	
	

}
