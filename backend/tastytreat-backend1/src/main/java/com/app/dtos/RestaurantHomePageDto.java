package com.app.dtos;

public class RestaurantHomePageDto {
	private int id;
	private String name;
	private String adressText;
	private int pinCode;
	
	public RestaurantHomePageDto() {
	}

	public RestaurantHomePageDto(int id, String name, String adressText, int pinCode) {
		super();
		this.id = id;
		this.name = name;
		this.adressText = adressText;
		this.pinCode = pinCode;
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

	public String getAdressText() {
		return adressText;
	}

	public void setAdressText(String adressText) {
		this.adressText = adressText;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

}
