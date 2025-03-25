package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Customer.State;
import com.valtech.assignment.ordermanagement.entities.LineOrder;
import com.valtech.assignment.ordermanagement.repos.LineOrderRepo;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;
import com.valtech.assignment.ordermanagement.vos.LineOrderVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LineOrderServiceImpl implements LineOrderService {

	@Autowired
	private LineOrderRepo lineOrderRepo;
	
	@Override
	public LineOrderVO saveLineOrder(LineOrderVO lvo) {
		return LineOrderVO.from(lineOrderRepo.save(lvo.to()));
	}
	
	
	@Override
	public List<LineOrderVO> getLineOrder(){
		return LineOrderVO.from(lineOrderRepo.findAll());
	}
	
	
	@Override
	public LineOrderVO getLineOrder(int id) {
		return LineOrderVO.from(lineOrderRepo.getReferenceById((long) id));
	}
	
}
