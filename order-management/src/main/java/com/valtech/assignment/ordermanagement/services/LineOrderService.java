package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.vos.LineOrderVO;

public interface LineOrderService {

	LineOrderVO saveLineOrder(LineOrderVO lvo);

	List<LineOrderVO> getLineOrder();

	LineOrderVO getLineOrder(int id);

}