package com.springboot.customerbank.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction
{
	@Id
	@Column(name = "transactionId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private String transactionNumber;
	private double amount;
	private String transactionType;
	private Integer accountid;
	private LocalDate transactionDate;
	
	public Transaction() {}

	public Transaction(Integer transactionId, String transactionNumber, double amount, String transactionType,
			Integer accountid, LocalDate transactionDate) {
		super();
		this.transactionId = transactionId;
		this.transactionNumber = transactionNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		this.accountid = accountid;
		this.transactionDate = transactionDate;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}