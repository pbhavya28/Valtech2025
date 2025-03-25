package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.entities.Orders;
import com.valtech.assignment.ordermanagement.entities.Orders.Status;

public record OrderVO(int id, Customer cust, List<LineOrder> lineOrder, String status) {

	public static OrderVO from(Orders order) {
		return new OrderVO(order.getId(),order.getCustomer(),order.getLineOrder(), order.getStatus().name()); 
	} 
	public Orders to() {
		Status status1 = Status.valueOf(status);
		System.out.println("iiiiiijjjjjjjjjlkkk"+ lineOrder.size());
		return new Orders(id,cust,lineOrder,status1);
	}
	public static List<OrderVO> from(List<Orders> orders){
		return orders.stream().map(order -> OrderVO.from(order)).collect(Collectors.toList());
	}
}
