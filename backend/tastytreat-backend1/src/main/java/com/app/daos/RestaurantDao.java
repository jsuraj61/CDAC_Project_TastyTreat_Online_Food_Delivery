package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{

}
