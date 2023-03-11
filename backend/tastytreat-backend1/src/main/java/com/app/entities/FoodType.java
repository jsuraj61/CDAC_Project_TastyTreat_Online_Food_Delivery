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
@Table(name = "food_type")
public class FoodType {

	/*
	 * CREATE TABLE food_type (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     name VARCHAR(100),
    ->
    ->     PRIMARY KEY (id)
    -> );
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "foodTypeId")
	private List<FoodItem> foodItems;

	public FoodType() {
		super();
	}

	public FoodType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "FoodType [id=" + id + ", name=" + name + "]";
	}
	
	
}
