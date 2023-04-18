package com.sunny.app.admin.dto;


public class GosuApplicationDTO {

	private int userNumber;
	private int applyNumber;
	private String applyContent;
	private String applyDate;
	private String applyTitle;
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getApplyNumber() {
		return applyNumber;
	}
	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
	}
	public String getApplyContent() {
		return applyContent;
	}
	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getApplyTitle() {
		return applyTitle;
	}
	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}
	@Override
	public String toString() {
		return "GosuApplicationDTO [userNumber=" + userNumber + ", applyNumber=" + applyNumber + ", applyContent="
				+ applyContent + ", applyDate=" + applyDate + ", applyTitle=" + applyTitle + "]";
	}
	
	
	
	
}
