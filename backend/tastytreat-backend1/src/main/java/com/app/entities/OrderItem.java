package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {

	/*
	 * CREATE TABLE order_item (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     order_id INT,
    ->     food_item_id INT,
    ->     food_item_name VARCHAR(100),
    ->     food_item_price DOUBLE,
    ->     quantity INT NOT NULL,
    ->
    ->     PRIMARY KEY (id),
    ->     FOREIGN KEY (order_id) REFERENCES orders(id),
    ->     FOREIGN KEY (food_item_id) REFERENCES food_item(id)
    ->
    -> );
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders orderId;
	
	@ManyToOne
	@JoinColumn(name="food_item_id")
	private FoodItem foodItemId;
	
	@Column(name="food_item_name")
	private String foodItemName;
	
	@Column(name="food_item_price")
	private double foodItemPrice;
	
	@Column
	private int quantity;

	public OrderItem() {
		super();
	}

	public OrderItem(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public OrderItem(Orders orderId, FoodItem foodItemId, String foodItemName, double foodItemPrice,
			int quantity) {
		super();
		this.orderId = orderId;
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemPrice = foodItemPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public FoodItem getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(FoodItem foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public double getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", foodItemId=" + foodItemId + ", foodItemName="
				+ foodItemName + ", foodItemPrice=" + foodItemPrice + ", quantity=" + quantity + "]";
	}
	
	
}
