package com.springboot.customerbank.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.query.Param;
import com.springboot.customerbank.dto.TransactionRequestDto;
import com.springboot.customerbank.dto.TransactionResponseDto;
import com.springboot.customerbank.dto.AmountRequestDto;
import com.springboot.customerbank.dto.AmountResponseDto;
import com.springboot.customerbank.entity.Transaction;

public interface TransactionService 
{
	TransactionResponseDto saveTransactionDetails(TransactionRequestDto transactionRequestDto);
	AmountResponseDto makeTransaction(AmountRequestDto amountRequestDto);
	List<TransactionResponseDto> getAllTransactions(Integer accountId);
	List<Transaction> getTransactionByDate(@Param("startDateTime") String startDateTime,@Param("endDateTime") String endDateTime);
}