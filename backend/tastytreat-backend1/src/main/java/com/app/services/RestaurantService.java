package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.RestaurantDao;
import com.app.daos.RestaurantManagerDao;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.RestManAndRestSignUpDto;
import com.app.dtos.RestaurantHomePageDto;
import com.app.entities.Restaurant;
import com.app.entities.RestaurantManager;

@Service
@Transactional
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private RestaurantManagerDao restaurantManagerDao;
	
	public List<Restaurant> findAllRestaurants() {
		return restaurantDao.findAll();
	}
	
	public List<RestaurantHomePageDto> findAllRestaurantHomePageDtos() {
		List<Restaurant> restList = restaurantDao.findAll();
		List<RestaurantHomePageDto> restDtoList = new ArrayList<RestaurantHomePageDto>();
		restList.forEach(rest -> restDtoList.add(DaoToEntityConverter.restaurantEntityToRestaurantHomePageDto(rest)));
		return restDtoList;
	}
	
	public boolean restManagerAndRestSignUp(RestManAndRestSignUpDto dto) {
		try {
			Restaurant rest = new Restaurant();
			rest.setName(dto.getRestaurantName());
			rest.setAdressText(dto.getRestaurantAdressText());
			rest.setPinCode(dto.getRestaurantPinCode());
			
			rest = restaurantDao.save(rest);
			entityManager.refresh(rest);
			
			RestaurantManager restMan = new RestaurantManager();
			restMan.setName(dto.getManagerName());
			restMan.setEmail(dto.getManagerEmail());
			restMan.setPassword(dto.getManagerPassword());
			restMan.setRestaurantId(rest);
			
			restMan = restaurantManagerDao.save(restMan);
			entityManager.refresh(restMan);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
