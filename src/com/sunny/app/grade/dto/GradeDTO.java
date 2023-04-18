package com.sunny.app.grade.dto;

public class GradeDTO {
	private int gradeNumber;
	private String gradeName;
	
	GradeDTO(){}

	public int getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "GradeDTO [gradeNumber=" + gradeNumber + ", gradeName=" + gradeName + "]";
	}
	
	

}
