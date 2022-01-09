package com.springboot.customerbank.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TransactionResponseDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer transactionId;
	private String transactionNumber;
	private double amount;
	private String transactionType;
	private Integer accountid;
	private LocalDate transactionDate;
	
	public TransactionResponseDto() {}

	public TransactionResponseDto(Integer transactionId, String transactionNumber, double amount,
			String transactionType, Integer accountid, LocalDate transactionDate) {
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