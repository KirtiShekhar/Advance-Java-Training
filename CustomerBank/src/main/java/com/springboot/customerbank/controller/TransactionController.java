package com.springboot.customerbank.controller;

import java.util.List;

import javax.validation.Valid;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.customerbank.dto.TransactionRequestDto;
import com.springboot.customerbank.dto.AmountRequestDto;
import com.springboot.customerbank.dto.AmountResponseDto;
import com.springboot.customerbank.dto.TransactionRequestDateDto;
import com.springboot.customerbank.entity.Transaction;
import com.springboot.customerbank.dto.TransactionResponseDto;
import com.springboot.customerbank.service.TransactionService;
import com.springboot.customerbank.repository.TransactionRepository;

@RestController
public class TransactionController 
{
	private static final Logger TransactionDetailsLogger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@PostMapping("/transaction")
	public ResponseEntity<String> saveTransaction(@Valid @RequestBody TransactionRequestDto transactionRequestDto)
	{
		transactionService.saveTransactionDetails(transactionRequestDto);
		TransactionDetailsLogger.info("Transaction Details Saving");
		return new ResponseEntity<String>("Transaction Detail Saved Successfully",HttpStatus.ACCEPTED); 
	}
	
	@PostMapping("/transaction/transfermoney")
	public AmountResponseDto makeTransaction(@RequestBody AmountRequestDto amountRequestDto)
	{
		AmountResponseDto amountResponseDto = transactionService.makeTransaction(amountRequestDto);
		TransactionDetailsLogger.info("Current Transactions Saving");
		return amountResponseDto; 
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionResponseDto>> getAllTransactionDetails(@RequestParam Integer accountId)
	{
		List<TransactionResponseDto> transactionResponseDto = transactionService.getAllTransactions(accountId);
		TransactionDetailsLogger.info("Fetching all the transactions"); 
		return new ResponseEntity<List<TransactionResponseDto>>(transactionResponseDto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/transaction/transactionbydate")
	public List<Transaction> getTransactionByDate(@RequestParam ("fromDate") String fromDate,@RequestParam ("toDate") String toDate)
	{
		List<Transaction> transactionList = transactionService.getTransactionByDate(fromDate, toDate);
		TransactionDetailsLogger.info("Fetching Transaction Details Based on from and to date");
		return transactionList;
	}
}