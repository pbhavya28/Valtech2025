package assignment2.spring;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
	
	@ManyToOne(targetEntity =Customer.class ,cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
	@JoinColumn(name="customerId" ,referencedColumnName = "id")
	private Customer customer;
	
	@OneToMany(targetEntity = LineOrder.class, mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<LineOrder> lineOrder;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public void addLineOrder(LineOrder lo) {
		if(lineOrder==null) lineOrder = new HashSet<LineOrder>();
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
	
	public Orders(Customer customer, Set<LineOrder> lineOrder, Status status) {
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
	public Set<LineOrder> getLineOrder() {
		return lineOrder;
	}
	public void setLineOrder(Set<LineOrder> lineOrder) {
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
