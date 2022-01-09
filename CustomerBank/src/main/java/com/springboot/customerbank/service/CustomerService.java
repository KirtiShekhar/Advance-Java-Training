package com.springboot.customerbank.service;

import java.util.List;
import com.springboot.customerbank.dto.CustomerRequestDto;
import com.springboot.customerbank.dto.CustomerResponse;
import com.springboot.customerbank.dto.CustomerResponseDto;

public interface CustomerService 
{
	boolean saveCustomerDetails(CustomerRequestDto customerRequestDto);
	List<CustomerResponseDto> getCustomerDetails(String customerName);
	List<CustomerResponseDto> getCustomerDetails();
	List<CustomerResponse> findCustomerDetailsByEmailId(String emailAddress);
	CustomerResponseDto getCustomerDetails(Integer customerId);
	boolean updateCustomerDetails(Integer customerId, CustomerRequestDto customerRequestDto);
	void deleteCustomerDetails(Integer customerId);
}
