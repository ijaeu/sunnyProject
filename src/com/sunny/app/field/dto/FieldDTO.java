package com.sunny.app.field.dto;
//field_number int unsigned auto_increment primary key,
//field_name varchar(100) not null
public class FieldDTO {
	private int fieldNumber;
	private String fieldName;
	
	public FieldDTO() {}

	public int getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String toString() {
		return "FieldDTO [fieldNumber=" + fieldNumber + ", fieldName=" + fieldName + "]";
	}
	
	
}
