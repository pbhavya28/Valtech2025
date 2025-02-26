package assignment2.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerAssign")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq" )
	@SequenceGenerator(name = "custSeq" ,sequenceName = "cust_seq", allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String address;
	private String per_address;
	
	public Customer() {}

	public Customer(String name, int age, String address, String per_address) {
//		super();
//		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.per_address = per_address;
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
	
	
	
	
	
}
