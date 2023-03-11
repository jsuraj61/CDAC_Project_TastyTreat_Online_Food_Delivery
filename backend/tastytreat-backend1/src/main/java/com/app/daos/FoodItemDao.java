package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.FoodItem;
import com.app.entities.Restaurant;

@Repository
public interface FoodItemDao extends JpaRepository<FoodItem, Integer> {


//	@Query("SELECT * FROM food_item WHERE food_item.restaurant_id=:p_restaurantId")
//	List<FoodItem> findFoodItemsByRestaurantId(@Param("p_restaurantId") int restaurantId);
	
	List<FoodItem> findFoodItemsByRestaurantId(Restaurant restaurantId);
}
