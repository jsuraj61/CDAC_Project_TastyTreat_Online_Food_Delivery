package com.app.dtos;

public class DeliveryPersonHomePageDto {

	/*
	 * {
	order_id: ,
	restaurant_name: ,
	restaurant_address: ,
	restaurant_pin_code:
	customer_name: ,
	customer_address: ,
	customer_pin_code: 
	}	
	 */
	
	private int orderId;
	private String restaurantName;
	private String restaurantAddress;
	private int restaurantPinCode;
	private String customerName;
	private String customerAddress;
	private int customerPinCode;
	
	public DeliveryPersonHomePageDto() {
		super();
	}
	
	public DeliveryPersonHomePageDto(int orderId, String restaurantName, String restaurantAddress, int restaurantPinCode,
			String customerName, String customerAddress, int customerPinCode) {
		super();
		this.orderId = orderId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantPinCode = restaurantPinCode;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPinCode = customerPinCode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public int getRestaurantPinCode() {
		return restaurantPinCode;
	}

	public void setRestaurantPinCode(int restaurantPinCode) {
		this.restaurantPinCode = restaurantPinCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCustomerPinCode() {
		return customerPinCode;
	}

	public void setCustomerPinCode(int customerPinCode) {
		this.customerPinCode = customerPinCode;
	}
	
	
	
}
