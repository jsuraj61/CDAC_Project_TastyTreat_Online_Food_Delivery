package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.OrderItemDao;
import com.app.entities.OrderItem;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;
	
	public List<OrderItem> findAllOrderItems() {
		return orderItemDao.findAll();
	}
}
