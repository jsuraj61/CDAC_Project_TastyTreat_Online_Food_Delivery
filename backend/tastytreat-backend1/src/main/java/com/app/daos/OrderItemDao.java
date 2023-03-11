package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer>{

}
