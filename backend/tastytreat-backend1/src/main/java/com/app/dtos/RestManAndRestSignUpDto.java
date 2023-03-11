package com.app.dtos;

public class RestManAndRestSignUpDto {
	private int restaurantId;
	private String restaurantName;
	private String restaurantAdressText;
	private int restaurantPinCode;
	
	private int managerId;
	private String managerName;
	private String managerEmail;
	private String managerPassword;
	
	public RestManAndRestSignUpDto() {
	}

	public RestManAndRestSignUpDto(int restaurantId, String restaurantName, String restaurantAdressText,
			int restaurantPinCode, int managerId, String managerName, String managerEmail, String managerPassword) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAdressText = restaurantAdressText;
		this.restaurantPinCode = restaurantPinCode;
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerPassword = managerPassword;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAdressText() {
		return restaurantAdressText;
	}

	public void setRestaurantAdressText(String restaurantAdressText) {
		this.restaurantAdressText = restaurantAdressText;
	}

	public int getRestaurantPinCode() {
		return restaurantPinCode;
	}

	public void setRestaurantPinCode(int restaurantPinCode) {
		this.restaurantPinCode = restaurantPinCode;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
	
}
