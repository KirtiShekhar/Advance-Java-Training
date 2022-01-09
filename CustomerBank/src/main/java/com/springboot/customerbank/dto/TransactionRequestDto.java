package com.springboot.customerbank.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransactionRequestDto
{
	private String transactionNumber;
	@Min(value = 1,message = "Amount should not be zero")
	@NotNull(message = "Amount cannot be null")
	@NotEmpty(message = "Amount cannot be empty")
	private double amount;
	@NotNull(message = "Transaction Type cannot be null")
	@NotEmpty(message = "Transaction Type cannot be empty")
	private String transactionType;
	@NotNull(message = "Account Id Cannot be empty cannot be null")
	@NotEmpty(message = "Account Id cannot be empty")
	private Integer accountid;
	
	public TransactionRequestDto() {}

	public TransactionRequestDto(String transactionNumber, double amount, String transactionType, Integer accountid) {
		super();
		this.transactionNumber = transactionNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		this.accountid = accountid;
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
	
	
}