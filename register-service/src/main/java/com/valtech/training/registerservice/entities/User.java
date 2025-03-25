package com.valtech.training.registerservice.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "userSeq",allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String mobile;
	private String email;
	@ManyToOne(targetEntity = Subscription.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	private Subscription subscription;
	private boolean isKidAccount;
	
	public User() {}



	public User(String name, int age, String mobile, String email, Subscription subscription, boolean isKidAccount) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.subscription = subscription;
		this.isKidAccount = isKidAccount;
	}



	public User(String name2, int age2, String mobile2, String email2, boolean isKidAccount2) {
		this.name = name2;
		this.age = age2;
		this.mobile = mobile2;
		this.email = email2;
		this.isKidAccount = isKidAccount2;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	public Subscription getSubscription() {
		return subscription;
	}



	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}



	public boolean isKidAccount() {
		return isKidAccount;
	}



	public void setKidAccount(boolean isKidAccount) {
		this.isKidAccount = isKidAccount;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", mobile=" + mobile + ", email=" + email
				+ ", subscription=" + subscription + ", isKidAccount=" + isKidAccount + "]";
	}





	
	
	
	
	
	
}
