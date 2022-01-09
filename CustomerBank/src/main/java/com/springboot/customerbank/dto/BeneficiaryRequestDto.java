package com.springboot.customerbank.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BeneficiaryRequestDto {

	@NotNull(message = "Account Number cannot be null")
	private Long accountNumber;
	@NotNull(message = "Beneficiary Account Number cannot be null")
	private Long beneficiaryAccount;
	@NotNull(message = "Beneficiary Name cannot be null")
	@NotEmpty(message = "Beneficiary Name cannot be empty")
	private String beneficiaryName;
	
	
	
	
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getBeneficiaryAccount() {
		return beneficiaryAccount;
	}
	public void setBeneficiaryAccount(Long beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}



}