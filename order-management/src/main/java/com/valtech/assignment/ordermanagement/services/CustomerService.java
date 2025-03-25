package com.valtech.assignment.ordermanagement.services;

import java.util.List;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.vos.CustomerVO;

public interface CustomerService {

//	void saveCustomer(Customer customer);

//	void enableCustomer(Customer customer);

//	void disableCustomer(Customer customer);

	CustomerVO saveCustomer(CustomerVO cvo);

	void enableCustomer(CustomerVO cvo);

	void disableCustomer(CustomerVO cvo);

	List<CustomerVO> getCustomers();

	CustomerVO getCustomer(int id);

}