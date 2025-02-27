package assignment2.spring;

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
	private int current_qty;
	private int reOrder_qty;
	private int max_qty;
	
	@OneToMany(targetEntity = LineOrder.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "item")
	private Set<LineOrder> getLineItems;
	
	public Item() {}

	public Item(String name, String disc, int current_qty, int reOrder_qty, int max_qty) {
//		super();
//		this.id = id;
		this.name = name;
		this.disc = disc;
		this.current_qty = current_qty;
		this.reOrder_qty = reOrder_qty;
		this.max_qty = max_qty;
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

	public int getCurrent_qty() {
		return current_qty;
	}

	public void setCurrent_qty(int current_qty) {
		this.current_qty = current_qty;
	}

	public int getMin_qty() {
		return reOrder_qty;
	}

	public void setReOrder_qty(int reOrder_qty) {
		this.reOrder_qty = reOrder_qty;
	}

	public int getMax_qty() {
		return max_qty;
	}

	public void setMax_qty(int max_qty) {
		this.max_qty = max_qty;
	}

	public Set<LineOrder> getGetLineItems() {
		return getLineItems;
	}

	public void setGetLineItems(Set<LineOrder> getLineItems) {
		this.getLineItems = getLineItems;
	}

	public int getReOrder_qty() {
		return reOrder_qty;
	}
	
	
	
}
