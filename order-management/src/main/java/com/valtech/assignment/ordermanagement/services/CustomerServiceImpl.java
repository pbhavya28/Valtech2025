package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.Customer.State;
import com.valtech.assignment.ordermanagement.repos.CustomerRepo;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;
import com.valtech.assignment.ordermanagement.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerVO saveCustomer(CustomerVO cvo) {
		return CustomerVO.from(customerRepo.save(cvo.to()));
//		customerRepo.save(customer);
	}
	
	@Override
	public void enableCustomer(CustomerVO cvo) {
//		customer.setState(State.ENABLED);
		cvo.to().setState(State.ENABLED);
	}
	
	@Override
	public void disableCustomer(CustomerVO cvo) {
		cvo.to().setState(State.DISABLED);
	}
	
	@Override
	public List<CustomerVO> getCustomers(){
		return CustomerVO.from(customerRepo.findAll());
	}
	
	@Override
	public CustomerVO getCustomer(int id) {
		return CustomerVO.from(customerRepo.getReferenceById((long) id));
	}
}
