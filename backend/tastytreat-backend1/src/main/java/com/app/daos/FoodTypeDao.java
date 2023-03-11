package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.FoodType;

public interface FoodTypeDao extends JpaRepository<FoodType, Integer> {

}
