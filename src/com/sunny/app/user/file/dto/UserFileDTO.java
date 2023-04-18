package com.sunny.app.user.file.dto;
//file_system_name varchar(300) primary key,
//file_original_name varchar(300) not null,
//user_number int unsigned not null,
public class UserFileDTO {
	private String fileSystemName;
	private String fileOriginalName;
	private int userNumber;
	
	public UserFileDTO() {}

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

	@Override
	public String toString() {
		return "UserFileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName
				+ ", userNumber=" + userNumber + "]";
	}
	
	
}
