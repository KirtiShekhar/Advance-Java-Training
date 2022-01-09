package com.springboot.customerbank.serviceImplementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.customerbank.dto.AccountResponse;
import com.springboot.customerbank.dto.BeneficiaryRequestDto;
import com.springboot.customerbank.dto.BeneficiaryResponseDto;
import com.springboot.customerbank.entity.Beneficiary;
import com.springboot.customerbank.repository.BeneficiaryRepository;
import com.springboot.customerbank.service.implementation.BeneficiaryServiceImplementation;

@ExtendWith(MockitoExtension.class)
class BeneficiaryServiceImplementationTest 
{
	@Mock
	BeneficiaryRepository beneficiaryRepository;

	@InjectMocks
	BeneficiaryServiceImplementation beneficiaryServiceImplementation;
	
	BeneficiaryRequestDto beneficiaryRequestDto;
	BeneficiaryResponseDto beneficiaryResponseDto;
	Beneficiary beneficiary;
	

	@BeforeEach
	public void setUp() throws Exception {
		beneficiaryRequestDto=new BeneficiaryRequestDto();
		beneficiaryRequestDto.setBeneficiaryName("Kirti Shekhar");
		beneficiaryRequestDto.setAccountNumber(66902545L);
		beneficiaryRequestDto.setBeneficiaryAccount(2489630L);
		
	}
	
	
	@Test
	@DisplayName("Save Beneficiary Details: Positive")
	public void getAllBeneficiaryTest()
	{
		when(beneficiaryRepository.findAll()).thenReturn(Stream.of(new Beneficiary(1, "Rajat", 123456L, 654321L)).collect(Collectors.toList()));
		//event
		List<Beneficiary> beneficiarysaveresult = beneficiaryServiceImplementation.getAllAccounts();
		//outcome
		assertEquals(1,beneficiarysaveresult.size());
	}

}
