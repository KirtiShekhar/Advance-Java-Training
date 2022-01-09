package com.springboot.customerbank.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springboot.customerbank.dto.TransactionRequestDto;
import com.springboot.customerbank.dto.TransactionResponseDto;
import com.springboot.customerbank.dto.AmountRequestDto;
import com.springboot.customerbank.dto.AmountResponseDto;
import com.springboot.customerbank.entity.Transaction;
import com.springboot.customerbank.service.TransactionService;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest 
{
	@Mock
	TransactionService transactionService;

	@InjectMocks
	TransactionController transactionController;
	
	Transaction transaction;
	TransactionRequestDto transactionRequestDto,transactionRequestDto1;
	TransactionResponseDto transactionResponseDto,transactionResponseDto1;
	AmountRequestDto amountRequestDto;
	AmountResponseDto amountResponseDto;
	
	@BeforeEach
	public void setUp()
	{
		transaction = new Transaction();
		transactionRequestDto = new TransactionRequestDto();
		transactionRequestDto1 = new TransactionRequestDto();
		transactionResponseDto = new TransactionResponseDto();
		
		transactionRequestDto.setAccountid(4);
		transactionRequestDto.setAmount(5000.00);
		transactionRequestDto.setTransactionNumber("SBTR224512");
		transactionRequestDto.setTransactionType("Debit");
		
		transactionRequestDto1.setAccountid(8);
		transactionRequestDto1.setAmount(9000.00);
		transactionRequestDto1.setTransactionNumber("AXI224512");
		transactionRequestDto1.setTransactionType("Credit");
		
		transactionResponseDto = new TransactionResponseDto(1, "SBTR224512", 5000.00, "Debit", 4, LocalDate.of(2021, 11, 11));
		
		amountRequestDto = new AmountRequestDto();
		
		amountRequestDto.setFromAccountNumber(61002545L);
		amountRequestDto.setToAccountNumber(63000L);
		amountRequestDto.setAmount(19000.00);
		amountResponseDto = new AmountResponseDto();
		amountResponseDto.setMessage("Transaction Successful");
	}
	
	
	@Test
	@DisplayName("Save Transaction Details : Positive")
	void SaveAccountInformationTest_Positive() 
	{
		// context
		when(transactionService.saveTransactionDetails(transactionRequestDto)).thenReturn(transactionResponseDto);
		//event
		ResponseEntity<String> transactionsaveresult = transactionController.saveTransaction(transactionRequestDto);
		//outcome
		assertEquals("Transaction Detail Saved Successfully", transactionsaveresult.getBody());
		assertEquals(HttpStatus.ACCEPTED, transactionsaveresult.getStatusCode());
	}
	
	@Test
	@DisplayName("Make Transaction")
	void TransferMoneyTest() 
	{
		// context
		when(transactionService.makeTransaction(amountRequestDto)).thenReturn(amountResponseDto);
		//event
		AmountResponseDto transactionsaveresult = transactionController.makeTransaction(amountRequestDto);
		//outcome
		assertEquals(transactionsaveresult,amountResponseDto);
	}

}
