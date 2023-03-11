package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.FoodItemDao;
import com.app.daos.FoodTypeDao;
import com.app.daos.RestaurantDao;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.FoodItemHomePageDto;
import com.app.entities.Customer;
import com.app.entities.FoodItem;
import com.app.entities.FoodType;
import com.app.entities.Restaurant;

@Service
public class FoodItemService {

	@Autowired
	private FoodItemDao foodItemDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private FoodTypeDao foodTypeDao;
	
	public List<FoodItem> findAllFoodItems() {
		return foodItemDao.findAll();
	}
	
	public List<FoodItemHomePageDto> findAllFoodItemsFromRestaurant(int restaurantId) {
		
		Restaurant restId = null;
		try {
			restId = restaurantDao.findById(restaurantId).get();
		} catch (Exception e) {
			return null;
		}
		
		
		List<FoodItem> foodItems = foodItemDao.findFoodItemsByRestaurantId(restId);
		List<FoodItemHomePageDto> foodItemsDtos = new ArrayList<FoodItemHomePageDto>();
		foodItems.forEach(foodItem -> foodItemsDtos.add(DaoToEntityConverter.foodItemEntityToFoodItemHomePageDto(foodItem)));
		return foodItemsDtos;
	}
	
	public List<FoodItemHomePageDto> findAllFoodItemsByIds(List<Integer> listOfFoodItems) {
		List<FoodItemHomePageDto> foodItemsDtos = new ArrayList<FoodItemHomePageDto>();
		FoodItem foodItem = null;
		
		for (Integer foodItemId : listOfFoodItems) {
			
			try {
				foodItem = foodItemDao.getById(foodItemId);
				foodItemsDtos.add(DaoToEntityConverter.foodItemEntityToFoodItemHomePageDto(foodItem));
			} catch (Exception e) {
				continue;
			}
		}
		return foodItemsDtos;
	}
	
	public boolean saveFoodItem(FoodItem food) {
		FoodItem foodItem = foodItemDao.save(food);
		System.out.println(foodItem.getId());
		return true;
	}
	
	public boolean saveFoodItemDto(FoodItemHomePageDto foodItemHomePageDto) {
		try {
			FoodItem foodItem = new FoodItem();
			
			FoodType foodtype = foodTypeDao.getById(foodItemHomePageDto.getFoodTypeId());
			Restaurant restaurant = restaurantDao.getById(foodItemHomePageDto.getRestaurantId());
			
			foodItem.setFoodTypeId(foodtype);
			foodItem.setRestaurantId(restaurant);
			foodItem.setName(foodItemHomePageDto.getName());
			foodItem.setPrice(foodItemHomePageDto.getPrice());
			foodItem.setVegetarian(foodItemHomePageDto.isVegetarian());
			foodItem.setImagePath(foodItemHomePageDto.getImagePath());
			
			foodItemDao.save(foodItem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}
	
	public FoodItemHomePageDto getDtoById(int foodItemId) {
		
		FoodItem fooditem = foodItemDao.getById(foodItemId);
		FoodItemHomePageDto foodItemHomePageDto = DaoToEntityConverter.foodItemAddEntityToDto(fooditem);
		return foodItemHomePageDto;
		
	}
	
	public boolean updateFoodItem(FoodItemHomePageDto foodItemHomePageDto) {
		try {
			FoodItem foodItem = foodItemDao.getById(foodItemHomePageDto.getId());
			foodItem.setName(foodItemHomePageDto.getName());
			foodItem.setFoodTypeId(foodTypeDao.getById(foodItemHomePageDto.getFoodTypeId()));
			foodItem.setPrice(foodItemHomePageDto.getPrice());
			foodItem.setImagePath(foodItemHomePageDto.getImagePath());
			foodItem.setVegetarian(foodItemHomePageDto.isVegetarian());
			
			foodItemDao.save(foodItem);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
