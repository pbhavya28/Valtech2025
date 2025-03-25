package com.valtech.training.registerservice.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub_seq")
	@SequenceGenerator(name = "sub_seq", sequenceName = "subSeq", allocationSize = 1)
	private int id;
	private int amount;
	private LocalDate startDate;
	private LocalDate endDate;
	@OneToMany(targetEntity = User.class,fetch = FetchType.LAZY,mappedBy = "subscription",cascade = CascadeType.ALL)
	private List<User> users;
	
	public Subscription() {}
	

	public void addUser(User user) {
		if (users == null) users = new ArrayList<User>();
		System.out.println("000000000000000" + user);
		users.add(user);
		user.setSubscription(this);
	}
	public void removeUser(User user) {
		users.remove(user);
		user.setSubscription(null);
	}

	public Subscription(int amount, LocalDate startDate, LocalDate endDate, List<User> users) {
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.users = users;
	}



	public Subscription(int amount2, LocalDate startDate1, LocalDate endDate1) {
		this.amount = amount2;
		this.startDate = startDate1;
		this.endDate = endDate1;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	

	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "Subscription [id=" + id + ", amount=" + amount + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", users=" + users + "]";
	}


	
	
	
	
	
}
