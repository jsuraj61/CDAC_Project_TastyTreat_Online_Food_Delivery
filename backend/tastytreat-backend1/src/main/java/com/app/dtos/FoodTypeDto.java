package com.app.dtos;

public class FoodTypeDto {
	private int id;
	private String name;
	
	public FoodTypeDto() {
	}

	public FoodTypeDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
