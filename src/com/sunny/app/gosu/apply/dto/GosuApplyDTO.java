package com.sunny.app.gosu.apply.dto;

import java.util.Date;

//*tbl_gosu_apply (고수신청)
//apply_number (pk) //int unsigned auto_increment 
//user_number (fk) //int
//apply_content //varchar(3000)
//apply_date //datetime

public class GosuApplyDTO {

	private int applyNumber;
	private int userNumber;
	private String applyContent;
	private Date applyDate;
	private String applyTitle;
	
	public GosuApplyDTO() {
	}

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

	public String getApplyContent() {
		return applyContent;
	}

	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
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
		return "GosuApplyDTO [applyNumber=" + applyNumber + ", userNumber=" + userNumber + ", applyContent="
				+ applyContent + ", applyDate=" + applyDate + ", applyTitle=" + applyTitle + "]";
	}

	
	
}
