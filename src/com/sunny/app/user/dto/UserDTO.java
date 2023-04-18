package com.sunny.app.user.dto;
//user_number int unsigned auto_increment primary key,
//user_id varchar(20) not null,
//user_password varchar(50) not null,
//user_name varchar(20) not null,
//user_nickname varchar(16) not null,
//user_phone varchar(20) not null,
//user_email varchar(100) not null,
//user_date datetime not null,
//user_comment varchar(100) default '한 줄 소개를 입력하세요',
//grade_number int unsigned,
public class UserDTO {
	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userPhone;
	private String userEmail;
	private String userDate;
	private String userComment;
	private int gradeNumber;
	
	public UserDTO() {}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public int getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	@Override
	public String toString() {
		return "UserDTO [userNumber=" + userNumber + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userNickname=" + userNickname + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + ", userDate=" + userDate + ", userComment=" + userComment
				+ ", gradeNumber=" + gradeNumber + "]";
	}
	
	
}
