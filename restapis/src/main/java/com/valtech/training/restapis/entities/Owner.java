package com.valtech.training.restapis.entities;

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
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ownerseq")
	@SequenceGenerator(name = "ownerseq", sequenceName = "owner_seq", allocationSize = 1)
	private long id;
	private String name;
	private String mobile;
	private String email;
	
	@OneToMany(targetEntity = Watch.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "owner")
	private List<Watch> watches;
	
	
	
	public Owner() {}
	
	
	public Owner(long id) {
		this.id = id;
	}


	public Owner(String name, String mobile, String email) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		
	}


	public void addWatch(Watch watch) {
		if(watches == null) new ArrayList<Watch>();
		watches.add(watch);
		watch.setOwner(this);
	}
	
	public void removeWatch(Watch watch) {
		watches.remove(watch);
		watch.setOwner(null);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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


	public List<Watch> getWatches() {
		return watches;
	}


	public void setWatches(List<Watch> watches) {
		this.watches = watches;
	}
	
	
	
	
}
