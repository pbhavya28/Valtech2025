package com.valtech.assignment.loanmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.valtech.assignment.loanmanagement.entities.Loan.Status;

@Entity
public class Loan {
	
	public enum LoanType{
		HOME, CAR
	}
	public enum Status{
		APPLIED,APPROVED,REJECTED
	}

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loanseq")
	@SequenceGenerator(name = "loanseq",sequenceName = "loan_seq")
	private int id;
	private String userName;
	private int aadhar;
	private int cibilScore;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	private String asset;
	private int assetValue;
	private int value;
	private int income;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Loan() {}
	public Loan(String userName, int aadhar, int cibilScore, LoanType loanType, String asset, int assetValue,
			int value, int income, Status status) {
		this.userName = userName;
		this.aadhar = aadhar;
		this.cibilScore = cibilScore;
		this.loanType = loanType;
		this.asset = asset;
		this.assetValue = assetValue;
		this.value = value;
		this.income = income;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAadhar() {
		return aadhar;
	}
	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}
	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public LoanType getLoanType() {
		return loanType;
	}
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public int getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(int assetValue) {
		this.assetValue = assetValue;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Loan [id=" + id + ", userName=" + userName + ", aadhar=" + aadhar + ", cibilScore=" + cibilScore
				+ ", loanType=" + loanType + ", asset=" + asset + ", assetValue=" + assetValue + ", value=" + value
				+ ", income=" + income + ", status=" + status + "]";
	}

	
	
	
	
}
