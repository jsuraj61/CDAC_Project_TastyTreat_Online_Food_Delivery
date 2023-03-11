package com.app.dtos;

public class FoodItemInOrderDto {
	private int foodItemId;
	private String foodName;
	private double foodPrice;
	private int foodQuantity;
	private String foodItemUrl;
	
	public FoodItemInOrderDto() {
	}

	public FoodItemInOrderDto(int foodItemId, String foodName, double foodPrice, int foodQuantity) {
		super();
		this.foodItemId = foodItemId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
	}
	
	

	public FoodItemInOrderDto(int foodItemId, String foodName, double foodPrice, int foodQuantity, String foodItemUrl) {
		super();
		this.foodItemId = foodItemId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.foodItemUrl = foodItemUrl;
	}

	public int getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	
	

	public String getFoodItemUrl() {
		return foodItemUrl;
	}

	public void setFoodItemUrl(String foodItemUrl) {
		this.foodItemUrl = foodItemUrl;
	}

	@Override
	public String toString() {
		return "FoodItemInOrderDto [foodItemId=" + foodItemId + ", foodName=" + foodName + ", foodPrice=" + foodPrice
				+ ", foodQuantity=" + foodQuantity + "]";
	}

	
}
