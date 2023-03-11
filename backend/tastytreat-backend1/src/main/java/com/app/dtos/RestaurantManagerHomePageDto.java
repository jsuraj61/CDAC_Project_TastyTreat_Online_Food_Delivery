package com.app.dtos;

public class RestaurantManagerHomePageDto {
	
	
	private int orderId;
	private int foodItemId;
	private String foodItemName;
	private String foodItemImagePath;
	private Double foodItemPrice;
	private int orderItemQuantity;
	
	
	
	public RestaurantManagerHomePageDto() {
		
	}
	

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public String getFoodItemImagePath() {
		return foodItemImagePath;
	}
	public void setFoodItemImagePath(String foodItemImagePath) {
		this.foodItemImagePath = foodItemImagePath;
	}
	public Double getFoodItemPrice() {
		return foodItemPrice;
	}
	public void setFoodItemPrice(Double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}
	
	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}
	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public RestaurantManagerHomePageDto(int orderId, int foodItemId, String foodItemName,
			String foodItemImagePath, Double foodItemPrice,
			int orderItemQuantity) {
		super();
		
		this.orderId = orderId;
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemImagePath = foodItemImagePath;
		this.foodItemPrice = foodItemPrice;
		
		this.orderItemQuantity = orderItemQuantity;
	}
	
	
	
	
	

}
