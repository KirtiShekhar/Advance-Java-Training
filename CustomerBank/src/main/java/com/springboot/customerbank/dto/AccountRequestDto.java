package com.springboot.customerbank.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountRequestDto 
{
	@NotNull(message = "account number cannot be null")
	private Long accountNumber;
	@NotNull(message = "balance number cannot be null")
	@Min(value = 1000, message = "account cannot be less than 1000")
	private double balance;
	@NotNull(message = "customer Id cannot be null")
	private Integer customerId;
	@NotNull(message = "Account Type cannot be null")
	@NotEmpty(message = "Account Type cannot be empty")
	private String accountType;
	
	public AccountRequestDto() {}

	public AccountRequestDto(Long accountNumber, double balance, Integer customerId, String accountType) {
		super();
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
