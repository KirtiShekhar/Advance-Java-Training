package com.springboot.customerbank.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.customerbank.dto.AccountRequestDto;
import com.springboot.customerbank.dto.AccountResponseDto;
import com.springboot.customerbank.dto.AccountResponse;
import com.springboot.customerbank.exception.CustomerNotFoundException;
import com.springboot.customerbank.service.AccountService;

@RestController
public class AccountController 
{
	private static final Logger AccountDetailsLogger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	AccountService accountService;
	
	@PostMapping("/account")
	public ResponseEntity<String> saveAccountInformation(@Valid @RequestBody AccountRequestDto accountRequestDto) throws CustomerNotFoundException
	{
		boolean savedaccount = accountService.saveAccountInformation(accountRequestDto);
		AccountDetailsLogger.info("Account Detail Saved Successfully");
		if(savedaccount)
		{
			return new ResponseEntity<String>("Account Saved Successfully",HttpStatus.CREATED); 
		}
		else
		{
			return new ResponseEntity<String>("Account Saved Unsuccessfully",HttpStatus.FORBIDDEN); 
		}
	}

	@GetMapping("/account")
	public List<AccountResponse> getAllAccountDetails()
	{
		AccountDetailsLogger.info("All Account Details Fetched");
		return accountService.getAllCustomerDetails();
	}
	
	@GetMapping(value="/account/{accountNumber}")
    public AccountResponseDto findAccountByAccountNumber(@PathVariable long accountNumber)
    {
		AccountDetailsLogger.info("Retrieved account  information with Account Number "+ accountNumber);
    	return accountService.findAccountByAccountNumber(accountNumber);
    }
	
	@PutMapping(value="/accounts")
    public ResponseEntity<String> updateAccountDetails(@RequestBody AccountRequestDto accountUpdateRequestDto,
    		@RequestParam Integer customerId)
   
    {
        accountService.updateAccountDetails(accountUpdateRequestDto,customerId);
        AccountDetailsLogger.info("Returning account Update information with CustomerId "+customerId+" was updated");
        return new ResponseEntity<String>("Update Account Successfully",HttpStatus.ACCEPTED);
    }
  	@DeleteMapping(value="/accounts")
    public ResponseEntity<String> deleteAccount(@RequestParam Integer customerId)
    {
        accountService.deleteAccount(customerId);
        AccountDetailsLogger.info("Returning account delete information with customerId  "+customerId+" was deleted");
        return new ResponseEntity<String>("Account Deleted Successfully",HttpStatus.OK);
    }
}

