package com.sunny.app.user.file.vo;

public class UserFileVO {
	private String fileSystemName;
	private String fileOriginalName;
	private int userNumber;
	private String userNickname;
	
	public UserFileVO() {}

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

	@Override
	public String toString() {
		return "UserFileVO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName
				+ ", userNumber=" + userNumber + ", userNickname=" + userNickname + "]";
	}
	
	
}
