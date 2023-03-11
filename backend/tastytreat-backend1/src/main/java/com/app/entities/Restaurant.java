package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	/*
	 * >CREATE TABLE restaurant (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     name VARCHAR(100),
    ->     address_text TEXT,
    ->     pin_code INT,
    ->
    ->     PRIMARY KEY (id)
    -> );*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column(name="address_text")
	private String adressText;
	@Column(name="pin_code")
	private int pinCode;
	
	@OneToOne(mappedBy = "restaurantId")
	private RestaurantManager restaurantmanager;
	
	@OneToMany(mappedBy = "restaurantId")
	private List<FoodItem> foodItems;
	
	@OneToMany(mappedBy = "restaurantId")
	private List<Orders> orders;
	
	public Restaurant() {
		super();
	}
	public Restaurant(int id, String name, String adressText, int pinCode) {
		super();
		this.id = id;
		this.name = name;
		this.adressText = adressText;
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
	public String getAdressText() {
		return adressText;
	}
	public void setAdressText(String adressText) {
		this.adressText = adressText;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public RestaurantManager getRestaurantmanager() {
		return restaurantmanager;
	}
	public void setRestaurantmanager(RestaurantManager restaurantmanager) {
		this.restaurantmanager = restaurantmanager;
	}
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", adressText=" + adressText + ", pinCode=" + pinCode + "]";
	}
	
	
	
}
