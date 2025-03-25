package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.Orders;
import com.valtech.assignment.ordermanagement.vos.OrderVO;
import com.valtech.assignment.ordermanagement.vos.PlaceOrderVO;

public interface OrderService {

//	void saveOrder(Orders order);

//	void updateOrder(Orders order);

	OrderVO getOrder(int id);

	List<OrderVO> getOrders();

	OrderVO updateOrder(OrderVO order);

//	void saveOrder(OrderVO orderVo);

	void saveOrder(PlaceOrderVO po);

//	void saveOrderThroughPlaceOrder(PlaceOrderVO placeOrderVO);

}