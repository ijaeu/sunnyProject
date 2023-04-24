package com.sunny.app.admin.vo;

import java.util.List;

import com.sunny.app.gosu.apply.file.dto.GosuApplyFileDTO;

public class GosuApplicationReadVO {
	
	private int userNumber;
	private String userNickname;
	private int gosuNumber;
	private int applyNumber;
	private String applyTitle;
	private String applyDate;
	private String applyContent;
	private String gosuFieldNames;
	private List<GosuApplyFileDTO> files;
	
	
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
	public int getGosuNumber() {
		return gosuNumber;
	}
	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}
	public int getApplyNumber() {
		return applyNumber;
	}
	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
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
	public List<GosuApplyFileDTO> getFiles() {
		return files;
	}
	public void setFiles(List<GosuApplyFileDTO> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "GosuApplicationReadVO [userNumber=" + userNumber + ", userNickname=" + userNickname + ", gosuNumber="
				+ gosuNumber + ", applyNumber=" + applyNumber + ", applyTitle=" + applyTitle + ", applyDate="
				+ applyDate + ", applyContent=" + applyContent + ", gosuFieldNames=" + gosuFieldNames + ", files="
				+ files + "]";
	}
	
	
	
	

}
