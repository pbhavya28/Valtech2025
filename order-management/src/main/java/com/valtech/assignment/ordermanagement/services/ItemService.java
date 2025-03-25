package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.Orders;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

public interface ItemService {

	ItemVO saveItem(ItemVO itemVo);

	ItemVO updateItem(ItemVO itemVo);

	ItemVO getItem(long id);

	List<ItemVO> getItems();

	void updateInventory(Orders o);

	void resetInventory(Item item);

	int getItemIdbyItemName(String name);



}