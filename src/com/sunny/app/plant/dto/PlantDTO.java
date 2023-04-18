package com.sunny.app.plant.dto;

//plant_number int unsigned auto_increment primary key,
//plant_name varchar(300) not null,
//plant_content varchar(3000) not null,
//algorithm_result varchar(300) not null,


public class PlantDTO {

	private int plantNumber;
	private String plantName;
	private String plantContent;
	private String algorithmResult;
	
	public PlantDTO() {}

	public int getPlantNumber() {
		return plantNumber;
	}

	public void setPlantNumber(int plantNumber) {
		this.plantNumber = plantNumber;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantContent() {
		return plantContent;
	}

	public void setPlantContent(String plantContent) {
		this.plantContent = plantContent;
	}

	public String getAlgorithmResult() {
		return algorithmResult;
	}

	public void setAlgorithmResult(String algorithmResult) {
		this.algorithmResult = algorithmResult;
	}

	@Override
	public String toString() {
		return "PlantDTO [plantNumber=" + plantNumber + ", plantName=" + plantName + ", plantContent=" + plantContent
				+ ", algorithmResult=" + algorithmResult + "]";
	}
	
	
}
