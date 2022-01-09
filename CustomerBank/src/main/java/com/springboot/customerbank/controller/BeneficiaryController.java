package com.springboot.customerbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.customerbank.dto.BeneficiaryRequestDto;
import com.springboot.customerbank.entity.Beneficiary;
import com.springboot.customerbank.repository.BeneficiaryRepository;
import com.springboot.customerbank.service.BeneficiaryService;

@RestController
public class BeneficiaryController 
{
	private static final Logger BeneficiaryDetailsLogger = LoggerFactory.getLogger(BeneficiaryController.class);
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/beneficiary")
	public ResponseEntity<String> addBeneficiary(@Valid @RequestBody BeneficiaryRequestDto beneficiaryDto)
	{
		boolean savedBeneficiary = beneficiaryService.addBeneficiary(beneficiaryDto);
		BeneficiaryDetailsLogger.info("Saving Beneficiary Data");
		if(savedBeneficiary)
		{
			return new ResponseEntity<String>("Beneficiary added Successfully",HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<String>("Beneficiary added Unsuccessfully",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/beneficiary")
	public List<Beneficiary> getAllAccounts()
	{
		List<Beneficiary> list = beneficiaryService.getAllAccounts();
		return list;
	}
	
	@DeleteMapping("/beneficiary/{beneficiaryId}")
	public ResponseEntity<String> deleteBeneficiary(@PathVariable Integer beneficiaryId)
	{
		String beneficiaryDeleted = beneficiaryService.deleteBeneficiaryData(beneficiaryId);
		BeneficiaryDetailsLogger.info("Deleted Beneficiary Data for given BeneficiaryId");
		if(beneficiaryDeleted == "beneficiary Deleted") 
		{
			return new ResponseEntity<String>("Beneficiary Deleted Successfully",HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<String>("Beneficiary Deleted Unsuccessfully",HttpStatus.NOT_FOUND);
		}
	}

}
