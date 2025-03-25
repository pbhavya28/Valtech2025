package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Customer;
import com.valtech.assignment.ordermanagement.entities.Customer.State;
import com.valtech.assignment.ordermanagement.entities.Item;

public record CustomerVO(int id,String name, int age, String address, String perAddress, String state) {

	public static CustomerVO from(Customer customer) {
		String status = customer.getState().name();
		return new CustomerVO(customer.getId(),customer.getName(),customer.getAge(),customer.getAddress(),customer.getPerAddress(),status);
	}
	public Customer to() {
		State states = State.valueOf(state);
		Customer customer =  new Customer(id,name, age, address,perAddress,states);
		return customer;
	}
	public static List<CustomerVO> from(List<Customer> custs){
		return custs.stream().map(cust -> CustomerVO.from(cust)).collect(Collectors.toList());
	}

}
