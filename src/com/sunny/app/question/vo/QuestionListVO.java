package com.sunny.app.question.vo;
//tq.question_number, tq.question_title, tq.question_date, tu.user_nickname, tuf.file_system_name
public class QuestionListVO {
	
	private int questionNumber;
	private int userNumber;
	private String questionTitle;
	private String questionDate;
	private String userNickname;
	private String fileSystemName;
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getFileSystemName() {
		return fileSystemName;
	}
	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}
	@Override
	public String toString() {
		return "QuestionListVO [questionNumber=" + questionNumber + ", userNumber=" + userNumber + ", questionTitle="
				+ questionTitle + ", questionDate=" + questionDate + ", userNickname=" + userNickname
				+ ", fileSystemName=" + fileSystemName + "]";
	}
	
}
