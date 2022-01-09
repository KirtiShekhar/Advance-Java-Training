package com.springboot.customerbank.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.springboot.customerbank.service.implementation.AccountServiceImplementation;
import com.springboot.customerbank.dto.AccountRequestDto;
import com.springboot.customerbank.dto.AccountResponseDto;
import com.springboot.customerbank.dto.AccountResponse;
import com.springboot.customerbank.repository.AccountRepository;
import com.springboot.customerbank.entity.Account;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplementationTest 
{
	@Mock
	AccountRepository accountRepository;

	@InjectMocks
	AccountServiceImplementation accountServiceImplementation;

	AccountRequestDto accountRequestDto;
	AccountResponseDto accountResponsesDto;
	AccountResponse accountResponse;
	Account account;

	@BeforeEach
	public void setUp()
	{
		accountRequestDto = new AccountRequestDto();
		accountResponsesDto = new AccountResponseDto();
		accountResponse = new AccountResponse();
		account = new Account();

		accountRequestDto.setAccountNumber(48225425L);
		accountRequestDto.setAccountType("Current Account");
		accountRequestDto.setBalance(99000.00);
		accountRequestDto.setCustomerId(9);
		
		accountResponsesDto.setAccountNumber(61002545L);
		accountResponsesDto.setAccountType("Saving");
		accountResponsesDto.setBalance(9000);
		accountResponsesDto.setCustomerId(4);

		account = new Account(); 
		account.setAccountNumber(610110213L);
		account.setAccountType("Saving Account");
		account.setBalance(99990.00);
		account.setCustomerId(11);
	}

	@Test
	@DisplayName("Save Account Details : Positive")
	void SaveAccountInformationTest_Positive() 
	{
		// context
		when(accountRepository.save(any(Account.class))).thenAnswer(i ->{
			Account account = i.getArgument(0);
			account.setAccountId(11);
			return account;
		});
		//event
		boolean accountsaveresult = accountServiceImplementation.saveAccountInformation(accountRequestDto);
		//outcome
		assertTrue(accountsaveresult);
	}

	@Test
	@DisplayName("Save Account Details : Negative")
	void SaveAccountInformationTest_Negative() 
	{
		// context
		when(accountRepository.save(any(Account.class))).thenReturn(null);
		//event
		boolean accountsaveresult = accountServiceImplementation.saveAccountInformation(accountRequestDto);
		//outcome
		assertFalse(accountsaveresult);
	}
	
	@Test
	@DisplayName("Get All Customer Details As AccountId and AccountNumber")
	void GetAllCustomerDetailsTest() 
	{
		when(accountRepository.findByAccount()).thenReturn(Stream.of(new AccountResponse(1,11000L),new AccountResponse(2,63000L)).collect(Collectors.toList()));
		//event 
		List<AccountResponse> accountdetails = accountServiceImplementation.getAllCustomerDetails(); 
		//outcome 
		assertEquals(2,accountdetails.size()); 
	}
	
	@Test
	@DisplayName("Get Account Details From AccountNumber")
	void FindAccountByAccountNumberTest() 
	{
		when(accountRepository.findByAccountNumber(61002545L)).thenReturn(accountResponsesDto);
		//event 
		AccountResponseDto accountdetails = accountServiceImplementation.findAccountByAccountNumber(61002545L); 
		//outcome 
		assertEquals(accountdetails,accountResponsesDto); 
	}
}
