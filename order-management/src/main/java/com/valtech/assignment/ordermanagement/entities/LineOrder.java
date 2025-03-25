package com.valtech.assignment.ordermanagement.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineorderseq")
	@SequenceGenerator(name = "lineorderseq", sequenceName = "line_order_seq",allocationSize = 1)
	private int id;
	
	@ManyToOne(targetEntity = Item.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name ="item_id", referencedColumnName = "id")
	private Item item;
	
	private int qty;
	
	@ManyToOne(targetEntity = Orders.class,fetch = FetchType.EAGER,optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders order;
	
	public LineOrder() {}
	public LineOrder(Item item, int qty, Orders order) {
//		super();
//		this.id = id;
		this.item = item;
		this.qty = qty;
		this.order = order;
	}
	public LineOrder(int id,Item item, int qty, Orders order) {
//		super();
		this.id = id;
		this.item = item;
		this.qty = qty;
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	

}
