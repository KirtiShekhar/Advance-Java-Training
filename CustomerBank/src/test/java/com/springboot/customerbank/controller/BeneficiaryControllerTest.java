package com.springboot.customerbank.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.customerbank.dto.BeneficiaryRequestDto;
import com.springboot.customerbank.dto.BeneficiaryResponseDto;
import com.springboot.customerbank.entity.Beneficiary;
import com.springboot.customerbank.service.BeneficiaryService;

@ExtendWith(MockitoExtension.class)
class BeneficiaryControllerTest 
{
	@Mock
	BeneficiaryService beneficiaryService;
	
	@InjectMocks
	BeneficiaryController beneficiaryController;
	
	BeneficiaryRequestDto beneficiaryRequestDto;
	BeneficiaryResponseDto beneficiaryResponseDto;
	Beneficiary beneficiary;
	

	@BeforeEach
	public void setUp() {
		beneficiaryRequestDto=new BeneficiaryRequestDto();
		beneficiaryRequestDto.setBeneficiaryName("Kirti Shekhar");
		beneficiaryRequestDto.setAccountNumber(66902545L);
		beneficiaryRequestDto.setBeneficiaryAccount(2489630L);
		
	}
	
	@Test
	@DisplayName("Save Beneficiary Details: Positive")
	public void addBeneficiaryTest_Positive()
	{
		when(beneficiaryService.addBeneficiary(beneficiaryRequestDto)).thenReturn(true);
		ResponseEntity<String> response=beneficiaryController.addBeneficiary(beneficiaryRequestDto);
		assertEquals("Beneficiary added Successfully",response.getBody());
		assertEquals(HttpStatus.ACCEPTED,response.getStatusCode());
	}
	
	@Test
	@DisplayName("Save Beneficiary Details: Negative")
	public void addBeneficiaryTest_Negative()
	{
		when(beneficiaryService.addBeneficiary(beneficiaryRequestDto)).thenReturn(false);
		ResponseEntity<String> response=beneficiaryController.addBeneficiary(beneficiaryRequestDto);
		assertEquals("Beneficiary added Unsuccessfully",response.getBody());
		assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
	}
	
	@Test
	@DisplayName("Delete Beneficiary Details: Positive")
	public void deleteBeneficiaryTest_Positive()
	{
		when(beneficiaryService.deleteBeneficiaryData(1)).thenReturn("beneficiary Deleted");
		ResponseEntity<String> response=beneficiaryController.deleteBeneficiary(1);
		assertEquals("Beneficiary Deleted Successfully",response.getBody());
		assertEquals(HttpStatus.FOUND,response.getStatusCode());
	}
	
	@Test
	@DisplayName("Delete Beneficiary Details: Negative")
	public void deleteBeneficiaryTest_Negative()
	{
		when(beneficiaryService.deleteBeneficiaryData(1)).thenReturn("");
		ResponseEntity<String> response=beneficiaryController.deleteBeneficiary(1);
		assertEquals("Beneficiary Deleted Unsuccessfully",response.getBody());
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	}

}
