package com.app.dtos;

public class DeliveryPersonDto {
	private int id;
	private String name;
	private String email;
	private boolean isAvailable;
	
	public DeliveryPersonDto() {
		super();
	}

	public DeliveryPersonDto(int id, String name, String email, boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.isAvailable = isAvailable;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
}
