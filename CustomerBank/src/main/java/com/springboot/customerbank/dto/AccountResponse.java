package com.springboot.customerbank.dto;

public class AccountResponse 
{
	private Integer accountId;
	private Long accountNumber;
	
	public AccountResponse() {}
	
	
	
	public AccountResponse(Integer accountId, Long accountNumber) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
	}



	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
