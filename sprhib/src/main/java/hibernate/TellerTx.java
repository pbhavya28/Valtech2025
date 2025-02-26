package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ttx")
//@Table(name = "Tellertxper")

public class TellerTx extends Tx {

	private String teller;
	private String branch;
	
	
	
	public TellerTx() {
		
	}


	public TellerTx(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}


	public TellerTx(double amount,String teller, String branch) {
		super(amount);
		this.teller = teller;
		this.branch = branch;
	}


	public String getTeller() {
		return teller;
	}


	public void setTeller(String teller) {
		this.teller = teller;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	@Override
	public String toString() {
		return "TellerTx [teller=" + teller + ", branch=" + branch + ", getId()=" + getId() + ", getAmount()="
				+ getAmount() + "]";
	}
	
	
	
}
