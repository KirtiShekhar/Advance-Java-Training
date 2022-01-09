package com.springboot.customerbank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.customerbank.dto.CustomerRequestDto;
import com.springboot.customerbank.dto.CustomerResponse;
import com.springboot.customerbank.dto.CustomerResponseDto;
import com.springboot.customerbank.service.CustomerService;

@RestController
public class CustomerController 
{
	private static final Logger CustomerDetailsLogger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<String> saveCustomerDetails(@Valid @RequestBody CustomerRequestDto customerRequestDto)
	{
		CustomerDetailsLogger.info("Saving Customer Data");
		boolean saveCustomerResponse = customerService.saveCustomerDetails(customerRequestDto);
		if(saveCustomerResponse)
		{
			return new ResponseEntity<String>("Customer Details Saved Successfully",HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<String>("Customer Details Saved Unsuccessfully",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<String> updateCustomerDetails(@PathVariable Integer customerId,@RequestBody CustomerRequestDto customerRequestDto)
	{
		CustomerDetailsLogger.info("Updating the existing Customer Data");
		boolean updateCustomerResponse = customerService.updateCustomerDetails(customerId,customerRequestDto);
		if(updateCustomerResponse)
		{
			return new ResponseEntity<String>("Customer Details Updated Successfully",HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<String>("Customer Details Updated Unsuccessfully",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/customer/customerName")
	List<CustomerResponseDto> getCustomerDetails(@RequestParam String customerName)
	{
		CustomerDetailsLogger.info("Fetching Customer Data for the entered Name");
		return customerService.getCustomerDetails(customerName);
	}

	@GetMapping("/customers/{customerId}")
	public CustomerResponseDto getCustomerDetails(@PathVariable Integer customerId)
	{
		CustomerDetailsLogger.info("Fetching Customer Data for the entered Id");
		return customerService.getCustomerDetails(customerId);
	}

	@GetMapping("/customers")
	public List <CustomerResponseDto>getCustomerDetails()
	{
		List<CustomerResponseDto> customerResponseList = customerService.getCustomerDetails();
		CustomerDetailsLogger.info("Fetching All Stored Customer Data");
		return customerResponseList;
		//return ResponseEntity.of(Optional.of(customerResponseList));
	}
	
	@GetMapping("/customer/emailAddress")
	public List<CustomerResponse> getCustomerDetailsByEmailID(@RequestParam String emailAddress) {
		return customerService.findCustomerDetailsByEmailId(emailAddress);
	}

	@DeleteMapping(value="/customers/{customerId}")
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable Integer customerId) 
	{
		CustomerDetailsLogger.info("Deleting the specified id Customer Data");
		customerService.deleteCustomerDetails(customerId);
		return new ResponseEntity<String>("customer data deleted",HttpStatus.OK);
	}
}
