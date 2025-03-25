package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Item;

public record ItemVO (int id ,String name, String disc, int currentQty, int reOrderQty, int maxQty){

	public static ItemVO from(Item item) {
		return new ItemVO(item.getId(),item.getName(),item.getDisc(),item.getCurrentQty(),item.getReOrderQty(),item.getMaxQty());
	}
	public Item to() {
		Item item =  new Item(id,name, disc, currentQty,reOrderQty,maxQty);
		return item;
	}
	public static List<ItemVO> from(List<Item> items){
		return items.stream().map(item -> ItemVO.from(item)).collect(Collectors.toList());
	}
}
