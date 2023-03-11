package com.app.dtos;

import com.app.entities.FoodType;
import com.app.entities.Restaurant;

public class FoodItemHomePageDto {
	
	private int id;
	private int foodTypeId;
	private int restaurantId;
	private String name;
	private double price;
	private boolean isVegetarian;
	private String imagePath;
	public FoodItemHomePageDto() {
		super();
	}
	public FoodItemHomePageDto(int id, int foodTypeId, int restaurantId, String name, double price,
			boolean isVegetarian, String imagePath) {
		super();
		this.id = id;
		this.foodTypeId = foodTypeId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.isVegetarian = isVegetarian;
		this.imagePath = imagePath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFoodTypeId() {
		return foodTypeId;
	}
	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isVegetarian() {
		return isVegetarian;
	}
	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
	
}
