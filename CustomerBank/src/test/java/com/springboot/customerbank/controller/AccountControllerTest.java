package com.springboot.customerbank.controller;

import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springboot.customerbank.dto.AccountRequestDto;
import com.springboot.customerbank.dto.AccountResponse;
import com.springboot.customerbank.dto.AccountResponseDto;
import com.springboot.customerbank.entity.Account;
import com.springboot.customerbank.service.AccountService;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest 
{
	@Mock
	AccountService accountService;

	@InjectMocks
	AccountController accountController;

	AccountRequestDto accountRequestDto;
	AccountResponseDto accountResponsesDto;
	AccountResponse accountResponse,accountResponse1;
	Account account;
	List<AccountResponse> accountResponseList;

	@BeforeEach
	public void setUp()
	{
		accountRequestDto = new AccountRequestDto();
		accountRequestDto.setAccountNumber(61002545L);
		accountRequestDto.setAccountType("Saving");
		accountRequestDto.setBalance(9000);
		accountRequestDto.setCustomerId(4);

		accountResponsesDto = new AccountResponseDto();
		accountResponsesDto.setAccountNumber(61002545L);
		accountResponsesDto.setAccountType("Saving");
		accountResponsesDto.setBalance(9000);
		accountResponsesDto.setCustomerId(4);

		/*	accountResponse = new AccountResponse(1,11000L);
		accountResponse1 = new AccountResponse(2,63000L);

		accountResponseList.add(accountResponse);
		accountResponseList.add(accountResponse1);*/
	}

	@Test
	@DisplayName("Save Account Details : Positive")
	void SaveAccountInformationTest_Positive() 
	{
		// context
		when(accountService.saveAccountInformation(accountRequestDto)).thenReturn(true);
		//event
		ResponseEntity<String> accountsaveresult = accountController.saveAccountInformation(accountRequestDto);
		//outcome
		assertEquals("Account Saved Successfully", accountsaveresult.getBody());
		assertEquals(HttpStatus.CREATED, accountsaveresult.getStatusCode());
	}

	@Test
	@DisplayName("Save Account Details : Negative")
	void SaveAccountInformationTest_Negative() 
	{
		// context
		when(accountService.saveAccountInformation(accountRequestDto)).thenReturn(false);
		//event
		ResponseEntity<String> accountsaveresult = accountController.saveAccountInformation(accountRequestDto);
		//outcome
		assertEquals("Account Saved Unsuccessfully", accountsaveresult.getBody());
		assertEquals(HttpStatus.FORBIDDEN, accountsaveresult.getStatusCode());
	}

	@Test
	@DisplayName("Get All Account Details By Account Number")
	void FindAccountByAccountNumberTest() 
	{
		// context
		when(accountService.findAccountByAccountNumber(61002545L)).thenReturn(accountResponsesDto);
		//event
		AccountResponseDto accountdetails = accountController.findAccountByAccountNumber(61002545L);
		//outcome
		assertEquals(accountdetails, accountResponsesDto);
	}


	@Test 
	@DisplayName("Get All Account Details") void GetAllAccountDetailsTest() { //
		//context
		when(accountService.getAllCustomerDetails()).thenReturn(Stream.of(new AccountResponse(1,11000L),new AccountResponse(2,63000L)).collect(Collectors.toList()));
		//event 
		List<AccountResponse> accountdetails = accountController.getAllAccountDetails(); 
		//outcome 
		assertEquals(2,accountdetails.size()); 
	}

}