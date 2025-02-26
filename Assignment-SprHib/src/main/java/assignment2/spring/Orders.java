package assignment2.spring;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq",allocationSize = 1)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customerId;
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<LineOrder> lineOrder;
	private String status;
	public Orders() {}
	public Orders(Customer customerId, Set<LineOrder> lineOrder, String status) {
//		super();
//		this.id = id;
		this.customerId = customerId;
		this.lineOrder = lineOrder;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
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
