package assignment2.spring;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineorderseq")
	@SequenceGenerator(name = "lineorderseq", sequenceName = "line_order_seq",allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	private Item item;
	
	private int qty;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	private Order order;
	
	public LineOrder() {}
	public LineOrder(Item item, int qty, Order order) {
//		super();
//		this.id = id;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
