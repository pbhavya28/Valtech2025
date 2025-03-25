package assignment2.spring.service;

import assignment2.spring.entities.Item;
import assignment2.spring.entities.Orders;

public interface InventoryService {

	void resetInventory(Item item);

	void updateInventory(Orders o);

}