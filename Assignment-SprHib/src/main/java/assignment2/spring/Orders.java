package assignment2.spring;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq",allocationSize = 1)
	private int id;
	
	@ManyToOne(targetEntity =Customer.class ,cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
	@JoinColumn(name="customerId" ,referencedColumnName = "id")
	private Customer customer;
	
	@OneToMany(targetEntity = LineOrder.class, mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<LineOrder> lineOrder;
	
	private String status;
	
	public Orders() {}
	public Orders(Customer customer, Set<LineOrder> lineOrder, String status) {
//		super();
//		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
