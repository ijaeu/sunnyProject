package com.sunny.app.admin.dto;

//SELECT user_number, user_id, user_password, user_name, user_nickname, 
//user_phone, user_email, user_date, user_comment, grade_number FROM tbl_user;

public class UserManageDTO {

	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userPhone;
	private String userEmail;
	private String userDate;
	private String gradeNumber;
	
	UserManageDTO(){}

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

	public String getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(String gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	@Override
	public String toString() {
		return "UserManageDTO [userNumber=" + userNumber + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userNickname=" + userNickname + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + ", userDate=" + userDate + ", gradeNumber=" + gradeNumber + "]";
	}

	
	
	
}
