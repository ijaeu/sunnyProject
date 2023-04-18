package com.sunny.app.plant.file.dto;

//file_system_name varchar(300) primary key,
//file_original_name varchar(300) not null,
//plant_number int unsigned not null,
//constraint fk_plant_file foreign key(plant_number) references tbl_plant(plant_number)



public class PlantFileDTO {

	private String fileSystemName;
	private String fileOriginalName;
	private int plantNumber;
	
	public PlantFileDTO() {}

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

	public int getPlantNumber() {
		return plantNumber;
	}

	public void setPlantNumber(int plantNumber) {
		this.plantNumber = plantNumber;
	}

	@Override
	public String toString() {
		return "PlantFileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName
				+ ", plantNumber=" + plantNumber + "]";
	}
	
	
}
