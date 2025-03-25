package com.valtech.assignment.ordermanagement.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Orders {
	
	public enum Status{
		IN_PROGRESS,
		REJECTED,
		DISPATCHED
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq",allocationSize = 1)
	private int id;
	
	@ManyToOne(targetEntity =Customer.class ,cascade = CascadeType.MERGE,fetch =  FetchType.LAZY)
	@JoinColumn(name="customerId" ,referencedColumnName = "id")
	private Customer customer;
	
	@OneToMany(targetEntity = LineOrder.class, mappedBy = "order", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private List<LineOrder> lineOrder;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public void addLineOrder(LineOrder lo) {
		if(lineOrder==null) lineOrder = new ArrayList<LineOrder>();
		lineOrder.add(lo);
		lo.setOrder(this);
		
	}
	public void removeLineOrder(LineOrder lo) {
		lineOrder.remove(lo);
		lo.setOrder(null);
	}
	
	public Orders() {}
//	public Orders(Customer customer, Set<LineOrder> lineOrder, String status) {
////		super();
////		this.id = id;
//		this.customer = customer;
//		this.lineOrder = lineOrder;
//		this.status = status;
//	}
	public Orders(int id,Customer customer, List<LineOrder> lineOrder, Status status) {
		this.id = id;
		this.customer = customer;
		this.lineOrder = lineOrder;
		this.status = status;
	}
	public Orders(int id,Customer customer, List<LineOrder> lineOrder) {
		this.id = id;
		this.customer = customer;
		this.lineOrder = lineOrder;
	}
	
	public Orders(Customer customer, List<LineOrder> lineOrder, Status status) {
		this.customer = customer;
		this.lineOrder = lineOrder;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<LineOrder> getLineOrder() {
		return lineOrder;
	}
	public void setLineOrder(List<LineOrder> lineOrder) {
		this.lineOrder = lineOrder;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
	
	
	
	
	

}
