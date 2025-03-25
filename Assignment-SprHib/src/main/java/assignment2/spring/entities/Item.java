package assignment2.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;




@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq" )
	@SequenceGenerator(name = "itemseq" ,sequenceName = "item_seq", allocationSize = 1)
	private int id;
	private String name;
	private String disc;
	private int currentQty;
	private int reOrderQty;
	private int maxQty;
	
	@OneToMany(targetEntity = LineOrder.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "item")
	private Set<LineOrder> getLineItems;
	
	public Item() {}

	public Item(String name, String disc, int current_qty, int reOrder_qty, int max_qty) {
//		super();
//		this.id = id;
		this.name = name;
		this.disc = disc;
		this.currentQty = current_qty;
		this.reOrderQty = reOrder_qty;
		this.maxQty = max_qty;
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

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public int getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(int current_qty) {
		this.currentQty = current_qty;
	}

	public void setReOrderQty(int reOrder_qty) {
		this.reOrderQty = reOrder_qty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int max_qty) {
		this.maxQty = max_qty;
	}

	public Set<LineOrder> getGetLineItems() {
		return getLineItems;
	}

	public void setGetLineItems(Set<LineOrder> getLineItems) {
		this.getLineItems = getLineItems;
	}

	public int getReOrderQty() {
		return reOrderQty;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", disc=" + disc + ", currentQty=" + currentQty + ", reOrderQty="
				+ reOrderQty + ", maxQty=" + maxQty + "]";
	}
	
	
	
}
