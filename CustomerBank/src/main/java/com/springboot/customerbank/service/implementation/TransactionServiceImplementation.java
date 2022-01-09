package com.springboot.customerbank.service.implementation;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.customerbank.dto.AmountRequestDto;
import com.springboot.customerbank.dto.AmountResponseDto;
import com.springboot.customerbank.dto.TransactionRequestDto;
import com.springboot.customerbank.dto.TransactionResponseDto;
import com.springboot.customerbank.entity.Transaction;
import com.springboot.customerbank.repository.AccountRepository;
import com.springboot.customerbank.repository.CustomerRepository;
import com.springboot.customerbank.repository.TransactionRepository;
import com.springboot.customerbank.service.TransactionService;
import com.springboot.customerbank.entity.Account;
import com.springboot.customerbank.exception.AccountNotFoundException;

@Service
public class TransactionServiceImplementation implements TransactionService 
{
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public TransactionResponseDto saveTransactionDetails(@Valid TransactionRequestDto transactionRequestDto) 
	{
		Optional<Account> optionalAccount=accountRepository.findById(transactionRequestDto.getAccountid());
		if(optionalAccount.isPresent()) 
		{
			Account account=accountRepository.findById(transactionRequestDto.getAccountid()).get();
			double amount=transactionRequestDto.getAmount();
			if(transactionRequestDto.getTransactionType().equalsIgnoreCase("Credit"))
			{
				account.setBalance(account.getBalance()+amount);
				accountRepository.save(account);
			}
			else
			{
				account.setBalance(account.getBalance()-amount);
				accountRepository.save(account);
			}
			Transaction transaction=new Transaction();
			transaction.setTransactionDate(LocalDate.now());
			BeanUtils.copyProperties(transactionRequestDto, transaction);
			transactionRepository.save(transaction);
			TransactionResponseDto transactionResponseDto=new TransactionResponseDto();
			BeanUtils.copyProperties(transaction, transactionResponseDto);
			return transactionResponseDto;
		}
		throw new AccountNotFoundException("Account doesn't exist for this id"+" "+transactionRequestDto.getAccountid());
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public AmountResponseDto makeTransaction(AmountRequestDto amountRequestDto) 
	{
		Account sourceAccount=accountRepository.findByAccountNumberEquals(amountRequestDto.getFromAccountNumber());
		Account destinationAccount=accountRepository.findByAccountNumberEquals(amountRequestDto.getToAccountNumber());
		sourceAccount.setBalance(sourceAccount.getBalance()-amountRequestDto.getAmount());
		accountRepository.save(sourceAccount);
		destinationAccount.setBalance(destinationAccount.getBalance()+amountRequestDto.getAmount());
		accountRepository.save(destinationAccount);

		AmountResponseDto amountResponseDto=new AmountResponseDto();
		BeanUtils.copyProperties(amountRequestDto, amountResponseDto);
		amountResponseDto.setMessage("Transaction Successful");
		return amountResponseDto;

	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<TransactionResponseDto> getAllTransactions(Integer accountid) 
	{
		Optional<Account> optionalAccount=accountRepository.findById(accountid);
		if(optionalAccount.isPresent()) 
		{
			List<TransactionResponseDto> transactionResponseList=new ArrayList<>();
			List<Transaction> transactionList=transactionRepository.findByAccountid(accountid);

			for(Transaction transaction:transactionList)
			{
				TransactionResponseDto transactionResponseDTO=new TransactionResponseDto();
				BeanUtils.copyProperties(transaction, transactionResponseDTO);
				transactionResponseList.add(transactionResponseDTO);
			}
			return transactionResponseList;
		}
		throw new AccountNotFoundException("Account doesn't exist for this id"+" "+accountid);
	}
	
	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<Transaction> getTransactionByDate(String fromDate,String toDate) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate startDate = LocalDate.parse(fromDate, formatter);
		LocalDate endDate = LocalDate.parse(toDate, formatter);
		List<Transaction> trn=transactionRepository.findTransactionByDate(startDate,endDate);
		return trn;
	}
}
