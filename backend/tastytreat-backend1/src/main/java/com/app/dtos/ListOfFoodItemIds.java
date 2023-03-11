package com.app.dtos;

import java.util.List;

public class ListOfFoodItemIds {
	private List<Integer> itemIds;
	
	public ListOfFoodItemIds() {
	}

	public ListOfFoodItemIds(List<Integer> itemIds) {
		super();
		this.itemIds = itemIds;
	}

	public List<Integer> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	@Override
	public String toString() {
		return "ListOfFoodItemIds [itemIds=" + itemIds + "]";
	}
	
	
}
