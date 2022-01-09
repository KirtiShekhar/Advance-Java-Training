package com.springboot.customerbank.service;

import java.util.List;
import com.springboot.customerbank.dto.AccountRequestDto;
import com.springboot.customerbank.dto.AccountResponseDto;
import com.springboot.customerbank.dto.AccountResponse;

public interface AccountService 
{
	boolean saveAccountInformation(AccountRequestDto accountRequestDto);
	List<AccountResponse> getAllCustomerDetails();
	AccountResponseDto findAccountByAccountNumber(long accountNumber);
	void updateAccountDetails(AccountRequestDto accountRequestUpdateDto,Integer customerId);
	void deleteAccount(Integer customerId);
}