package com.springboot.customerbank.service;

import java.util.List;

import com.springboot.customerbank.dto.BeneficiaryRequestDto;
import com.springboot.customerbank.entity.Beneficiary;

public interface BeneficiaryService {

	boolean addBeneficiary(BeneficiaryRequestDto beneficiaryRequestDto);
	
	String deleteBeneficiaryData(Integer beneficiaryId);
	
	public List<Beneficiary> getAllAccounts();

}
