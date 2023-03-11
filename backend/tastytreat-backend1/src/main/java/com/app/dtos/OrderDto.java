package com.app.dtos;

import java.util.List;

public class OrderDto {


	List<Integer> orderIds;
	

	public OrderDto() {
		super();
	}

	public List<Integer> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Integer> orderIds) {
		this.orderIds = orderIds;
	}

	public OrderDto(List<Integer> orderIds) {
		super();
		this.orderIds = orderIds;
	}

	@Override
	public String toString() {
		return "OrderDto [orderIds=" + orderIds + "]";
	}
	
	
	
}
