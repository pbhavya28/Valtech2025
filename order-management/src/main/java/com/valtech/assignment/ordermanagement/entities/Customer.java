package com.valtech.assignment.ordermanagement.entities;

import java.util.Set;

import com.valtech.assignment.ordermanagement.entities.Orders.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerAssign")
public class Customer {

	public enum State{
		ENABLED, DISABLED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq" )
	@SequenceGenerator(name = "custSeq" ,sequenceName = "cust_seq", allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String address;
	private String perAddress;
	@Enumerated(EnumType.STRING)
	private State state;
	
	
	@OneToMany(targetEntity = Orders.class, fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.MERGE)
	private Set<Orders> orders;
	
	public Customer() {}

	public Customer(String name, int age, String address, String per_address) {
//		super();
//		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = per_address;
		this.state = State.ENABLED;
		
	}
	public Customer(int id,String name, int age, String address, String per_address, State state) {
//		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = per_address;
		this.state = State.ENABLED;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPerAddress() {
		return perAddress;
	}

	public void setPerAddress(String per_address) {
		this.perAddress = per_address;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
		
}
