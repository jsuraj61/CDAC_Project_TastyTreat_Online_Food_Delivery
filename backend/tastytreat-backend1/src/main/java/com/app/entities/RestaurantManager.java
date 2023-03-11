package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_manager")
public class RestaurantManager {
/*
 * CREATE TABLE restaurant_manager (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     name VARCHAR(100),
    ->     email VARCHAR(100),
    ->     password VARCHAR(255),
    ->     restaurant_id INT,
    ->
    ->     PRIMARY KEY (id),
    ->     FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
    -> );*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@OneToOne
	@JoinColumn(name="restaurant_id")
	
	private Restaurant restaurantId;

	public RestaurantManager() {
		super();
	}

	public RestaurantManager(int id, String name, String email, String password, Restaurant restaurantId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.restaurantId = restaurantId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "RestaurantManager [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", restaurantId=" + restaurantId + "]";
	}
	
	
	
}
