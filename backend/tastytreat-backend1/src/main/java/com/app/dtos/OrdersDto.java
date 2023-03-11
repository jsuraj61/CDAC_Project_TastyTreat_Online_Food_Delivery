package com.app.dtos;

import java.util.List;

public class OrdersDto {
	private int orderId;
	private List<FoodItemInOrderDto> foodItems;
	private CustomerDto customer;
	private RestaurantHomePageDto restaurant;
	private String status;
	private DeliveryPersonDto deliveryPerson;
	
	public OrdersDto() {
	}

	
	public OrdersDto(int orderId, List<FoodItemInOrderDto> foodItems, CustomerDto customer,
			RestaurantHomePageDto restaurant, String status) {
		super();
		this.orderId = orderId;
		this.foodItems = foodItems;
		this.customer = customer;
		this.restaurant = restaurant;
		this.status = status;
	}


	public OrdersDto(int orderId, List<FoodItemInOrderDto> foodItems, CustomerDto customer,
			RestaurantHomePageDto restaurant, String status, DeliveryPersonDto deliveryPerson) {
		super();
		this.orderId = orderId;
		this.foodItems = foodItems;
		this.customer = customer;
		this.restaurant = restaurant;
		this.status = status;
		this.deliveryPerson = deliveryPerson;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<FoodItemInOrderDto> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItemInOrderDto> foodItems) {
		this.foodItems = foodItems;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public RestaurantHomePageDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantHomePageDto restaurant) {
		this.restaurant = restaurant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public DeliveryPersonDto getDeliveryPerson() {
		return deliveryPerson;
	}


	public void setDeliveryPerson(DeliveryPersonDto deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}
	
	
	
}
