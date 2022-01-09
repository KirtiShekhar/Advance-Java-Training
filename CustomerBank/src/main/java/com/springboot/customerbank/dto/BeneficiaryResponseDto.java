package com.springboot.customerbank.dto;

public class BeneficiaryResponseDto 
{
	private Integer beneficiaryId;
	private String beneficiaryName;
	private Long accountNumber;
	private Long beneficiaryAccount;
	
	
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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
	
	
	
	public BeneficiaryResponseDto(Integer beneficiaryId, String beneficiaryName, Long accountNumber,
			Long beneficiaryAccount) {
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.accountNumber = accountNumber;
		this.beneficiaryAccount = beneficiaryAccount;
	}
	public BeneficiaryResponseDto() {}

}
