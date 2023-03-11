package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Entity
@Table(name = "food_item")
public class FoodItem {
/*
 * CREATE TABLE food_item (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     food_type_id INT,
    ->     restaurant_id INT,
    ->     name VARCHAR(100),
    ->     price DOUBLE,
    ->     is_vegetarian BOOLEAN,
    ->     image_path TEXT,
    ->
    ->     PRIMARY KEY (id),
    ->     FOREIGN KEY (food_type_id) REFERENCES food_type(id),
    ->     FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
    -> );
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "food_type_id")
	
	private FoodType foodTypeId;
    
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurantId;
    
    @Column
	private String name;
    
    @Column
	private double price;
    
    @Column(name="is_vegetarian")
	private boolean isVegetarian;
    
    @Column(name="image_path")
	private String imagePath;
    
    @OneToMany(mappedBy = "foodItemId")
	private List<OrderItem> orderItem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FoodType getFoodTypeId() {
		return foodTypeId;
	}

	public void setFoodTypeId(FoodType foodTypeId) {
		this.foodTypeId = foodTypeId;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
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

	public FoodItem() {
		super();
	}

	public FoodItem(int id, String name, double price, boolean isVegetarian) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isVegetarian = isVegetarian;
	}
	
	

	public FoodItem(FoodType foodTypeId, Restaurant restaurantId, String name, double price, boolean isVegetarian,
			String imagePath) {
		super();
		this.foodTypeId = foodTypeId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.isVegetarian = isVegetarian;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", foodTypeId=" + foodTypeId + ", restaurantId=" + restaurantId + ", name=" + name
				+ ", price=" + price + ", isVegetarian=" + isVegetarian + ", imagePath=" + imagePath + "]";
	}
	
	
}
