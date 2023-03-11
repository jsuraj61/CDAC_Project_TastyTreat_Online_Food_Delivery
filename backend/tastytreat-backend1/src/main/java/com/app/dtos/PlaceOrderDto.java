package com.app.dtos;

import java.util.List;

public class PlaceOrderDto {

	private List<FoodItemInOrderDto> foodItemsInOrder;
	private int restaurantId;
	private int customerId;
	
	public PlaceOrderDto() {
	}

	public PlaceOrderDto(List<FoodItemInOrderDto> foodItemsInOrder, int restaurantId, int customerId) {
		super();
		this.foodItemsInOrder = foodItemsInOrder;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
	}

	public List<FoodItemInOrderDto> getFoodItemsInOrder() {
		return foodItemsInOrder;
	}

	public void setFoodItemsInOrder(List<FoodItemInOrderDto> foodItemsInOrder) {
		this.foodItemsInOrder = foodItemsInOrder;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "PlaceOrderDto [foodItemsInOrder=" + foodItemsInOrder + ", restaurantId=" + restaurantId
				+ ", customerId=" + customerId + "]";
	}
	
	
	
	
}
