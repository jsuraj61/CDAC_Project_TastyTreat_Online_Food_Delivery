package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.RestaurantManager;

public interface RestaurantManagerDao extends JpaRepository<RestaurantManager, Integer> {
        
	RestaurantManager findByEmail(String email);
	
	
}
