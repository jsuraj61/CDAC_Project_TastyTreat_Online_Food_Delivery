package com.app.dtos;

import com.app.entities.Restaurant;

public class RestaurantManagerDto {

	private int id;
	private String email;
	private String name;
	private int restaurantId;
	private String restaurantName;
	
	
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public RestaurantManagerDto() {
		super();
	}
	
	
	
	public RestaurantManagerDto(int id, String email, String name, int restaurantId) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.restaurantId = restaurantId;
	}

	
	
	public RestaurantManagerDto(int id, String email, String name, int restaurantId, String restaurantName) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	
	
}
