package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.entities.Orders;

public record LineOrderVO(int id, Item item, int qty, Orders order) {


	public static LineOrderVO from(LineOrder lo) {
		return new LineOrderVO(lo.getId(),lo.getItem(),lo.getQty(),lo.getOrder());
	} 
	public static List<LineOrderVO> from (List<LineOrder> lo){
		return  lo.stream().map(lineI -> LineOrderVO.from(lineI)).collect(Collectors.toList());
	}
	public LineOrder to() {
		return new LineOrder(id,item,qty,order);
	}
}
