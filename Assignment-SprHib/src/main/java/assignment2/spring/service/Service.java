package assignment2.spring.service;

import assignment2.spring.entities.LineOrder;
import assignment2.spring.entities.Orders;

public interface Service {

	void saveOrder(Orders o);

	void saveLineOrder(LineOrder lo);

}