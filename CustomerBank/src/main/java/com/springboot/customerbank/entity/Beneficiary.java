package com.springboot.customerbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Beneficiary")
public class Beneficiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beneficiaryId;
	private String beneficiaryName;
	private Long accountNumber;
	private Long beneficiaryAccount;
	
	public Beneficiary() {}
	
	
	
	
	public Beneficiary(Integer beneficiaryId, String beneficiaryName, Long accountNumber, Long beneficiaryAccount) {
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.accountNumber = accountNumber;
		this.beneficiaryAccount = beneficiaryAccount;
	}




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
	
	

}