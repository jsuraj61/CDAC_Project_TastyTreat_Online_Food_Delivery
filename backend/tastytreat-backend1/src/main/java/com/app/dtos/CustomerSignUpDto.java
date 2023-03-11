package com.app.dtos;

public class CustomerSignUpDto {
	private int id;
	private String name;
	private String email;
	private String password;
	private String addressText;
	private int pinCode;
	
	
	public CustomerSignUpDto() {
	}

	public CustomerSignUpDto(int id, String name, String email, String password, String addressText, int pinCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.addressText = addressText;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
}
