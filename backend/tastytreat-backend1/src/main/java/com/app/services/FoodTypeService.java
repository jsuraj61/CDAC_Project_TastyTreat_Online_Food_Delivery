package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.FoodTypeDao;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.FoodTypeDto;
import com.app.entities.FoodType;

@Service
public class FoodTypeService {

	@Autowired
	private FoodTypeDao foodTypeDao;
	
	public List<FoodTypeDto> findAllFoodTypes(){
		List<FoodType> foodTypeList = foodTypeDao.findAll();
		List<FoodTypeDto> foodtypeDtolist = new ArrayList<FoodTypeDto>();
				
		foodTypeList.forEach(foodType -> foodtypeDtolist.add(DaoToEntityConverter.FoodTypeToFoodTypeDto(foodType)));
		return foodtypeDtolist;
	}
}
