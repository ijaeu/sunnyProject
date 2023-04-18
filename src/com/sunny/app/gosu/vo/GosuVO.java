package com.sunny.app.gosu.vo;

public class GosuVO {
	
	private int userNumber;
	private String userNickname;
	private String userComment;
	private String gosuFields;
	private int gosuNumber;
	private String fileSystemName;
	
	public GosuVO() {	}

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

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public String getGosuFields() {
		return gosuFields;
	}

	public void setGosuFields(String gosuFields) {
		this.gosuFields = gosuFields;
	}

	public int getGosuNumber() {
		return gosuNumber;
	}

	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}

	public String getFileSystemName() {
		return fileSystemName;
	}

	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}

	@Override
	public String toString() {
		return "GosuVO [userNumber=" + userNumber + ", userNickname=" + userNickname + ", userComment=" + userComment
				+ ", gosuFields=" + gosuFields + ", gosuNumber=" + gosuNumber + ", fileSystemName=" + fileSystemName
				+ "]";
	}


}
