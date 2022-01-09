package com.springboot.customerbank.dto;

import java.io.Serializable;

public class AccountResponseDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Long accountNumber;
	private double balance;
	private Integer customerId;
	private String accountType;
	
	public AccountResponseDto() {}

	

	public AccountResponseDto(Long accountNumber, double balance, Integer customerId, String accountType) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerId = customerId;
		this.accountType = accountType;
	}



	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}