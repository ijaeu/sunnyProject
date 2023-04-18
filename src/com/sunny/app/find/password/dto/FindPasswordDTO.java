package com.sunny.app.find.password.dto;
//find_password_number int unsigned auto_increment primary key,
//find_password_answer varchar(300) not null,
//find_question_number int unsigned not null,
//user_number int unsigned not null,
public class FindPasswordDTO {
	private int findPasswordNumber;
	private String findPasswordAnswer;
	private int findQuestionNumber;
	private int userNumber;
	
	public FindPasswordDTO() {}

	public int getFindPasswordNumber() {
		return findPasswordNumber;
	}

	public void setFindPasswordNumber(int findPasswordNumber) {
		this.findPasswordNumber = findPasswordNumber;
	}

	public String getFindPasswordAnswer() {
		return findPasswordAnswer;
	}

	public void setFindPasswordAnswer(String findPasswordAnswer) {
		this.findPasswordAnswer = findPasswordAnswer;
	}

	public int getFindQuestionNumber() {
		return findQuestionNumber;
	}

	public void setFindQuestionNumber(int findQuestionNumber) {
		this.findQuestionNumber = findQuestionNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return "FindPasswordDTO [findPasswordNumber=" + findPasswordNumber + ", findPasswordAnswer="
				+ findPasswordAnswer + ", findQuestionNumber=" + findQuestionNumber + ", userNumber=" + userNumber
				+ "]";
	}
	
	
}
