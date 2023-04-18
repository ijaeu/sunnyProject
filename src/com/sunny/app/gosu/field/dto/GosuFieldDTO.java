package com.sunny.app.gosu.field.dto;

public class GosuFieldDTO {
	
	private int gosuFieldNumber;
	private int fieldNumber;
	private int gosuNumber;

	public GosuFieldDTO() {
	}

	public int getGosuFieldNumber() {
		return gosuFieldNumber;
	}

	public void setGosuFieldNumber(int gosuFieldNumber) {
		this.gosuFieldNumber = gosuFieldNumber;
	}

	public int getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public int getGosuNumber() {
		return gosuNumber;
	}

	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}

	@Override
	public String toString() {
		return "GosuFieldDTO [gosuFieldNumber=" + gosuFieldNumber + ", fieldNumber=" + fieldNumber + ", gosuNumber="
				+ gosuNumber + "]";
	}

	
	
	
}
