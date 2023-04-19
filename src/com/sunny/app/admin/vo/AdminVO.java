package com.sunny.app.admin.vo;

public class AdminVO {
	
	private int adminNumber;
	private String adminId;
	private String adminPassword;
	private String adminName;
	private String adminTeam;
	private String fileSystemName;
	private String fileOriginalName;
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminTeam() {
		return adminTeam;
	}
	public void setAdminTeam(String adminTeam) {
		this.adminTeam = adminTeam;
	}
	public String getFileSystemName() {
		return fileSystemName;
	}
	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	@Override
	public String toString() {
		return "AdminVO [adminNumber=" + adminNumber + ", adminId=" + adminId + ", adminPassword=" + adminPassword
				+ ", adminName=" + adminName + ", adminTeam=" + adminTeam + ", fileSystemName=" + fileSystemName
				+ ", fileOriginalName=" + fileOriginalName + "]";
	}
	
	
}
