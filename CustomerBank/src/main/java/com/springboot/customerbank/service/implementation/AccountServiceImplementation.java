package com.springboot.customerbank.service.implementation;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.customerbank.dto.AccountRequestDto;
import com.springboot.customerbank.dto.AccountResponse;
import com.springboot.customerbank.dto.AccountResponseDto;
import com.springboot.customerbank.entity.Account;
import com.springboot.customerbank.repository.AccountRepository;
import com.springboot.customerbank.repository.CustomerRepository;
import com.springboot.customerbank.service.AccountService;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;

@Service
public class AccountServiceImplementation implements AccountService 
{
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public boolean saveAccountInformation(@Valid AccountRequestDto accountRequestDto) 
	{
		Account account = new Account();
		BeanUtils.copyProperties(accountRequestDto, account);
		Account savedaccount = accountRepository.save(account);
		if(savedaccount != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<AccountResponse> getAllCustomerDetails() 
	{
		return accountRepository.findByAccount();
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public AccountResponseDto findAccountByAccountNumber(long accountNumber) 
	{
		return accountRepository.findByAccountNumber(accountNumber);
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public void updateAccountDetails(AccountRequestDto accountRequestUpdateDto, Integer customerId) 
	{
		Account account = accountRepository.findByCustomerId(customerId);
		BeanUtils.copyProperties(accountRequestUpdateDto, account);
		accountRepository.save(account);
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public void deleteAccount(Integer customerId) 
	{
		accountRepository.deleteById(customerId);
	}
}
