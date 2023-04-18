package com.sunny.app.find.password.question.dto;
//find_question_number int unsigned auto_increment primary key,
//find_question_content varchar(300) not null
public class FindPasswordQuestionDTO {
	private int findQuestionNumber;
	private String findQuestionContent;
	
	public FindPasswordQuestionDTO() {}

	public int getFindQuestionNumber() {
		return findQuestionNumber;
	}

	public void setFindQuestionNumber(int findQuestionNumber) {
		this.findQuestionNumber = findQuestionNumber;
	}

	public String getFindQuestionContent() {
		return findQuestionContent;
	}

	public void setFindQuestionContent(String findQuestionContent) {
		this.findQuestionContent = findQuestionContent;
	}

	@Override
	public String toString() {
		return "FindPasswordQuestionDTO [findQuestionNumber=" + findQuestionNumber + ", findQuestionContent="
				+ findQuestionContent + "]";
	}
	
	
}
