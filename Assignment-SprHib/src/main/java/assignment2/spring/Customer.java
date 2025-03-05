package assignment2.spring;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import assignment2.spring.Orders.Status;

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
	private String per_address;
	@Enumerated(EnumType.STRING)
	private State state;
	
	
	@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "")
	private Set<Orders> orders;
	
	public Customer() {}

	public Customer(String name, int age, String address, String per_address) {
//		super();
//		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.per_address = per_address;
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

	public String getPer_address() {
		return per_address;
	}

	public void setPer_address(String per_address) {
		this.per_address = per_address;
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
