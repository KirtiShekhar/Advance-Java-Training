package com.springboot.customerbank.service.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.customerbank.dto.CustomerRequestDto;
import com.springboot.customerbank.dto.CustomerResponse;
import com.springboot.customerbank.dto.CustomerResponseDto;
import com.springboot.customerbank.entity.Customer;
import com.springboot.customerbank.exception.InputErrorException;
import com.springboot.customerbank.repository.CustomerRepository;
import com.springboot.customerbank.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService 
{
	@Autowired
	CustomerRepository customerRepository;

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public boolean saveCustomerDetails(@Valid CustomerRequestDto customerRequestDto) 
	{
		Customer customerContactNumber = customerRepository.findByContactNumber(customerRequestDto.getContactNumber());
		if(customerContactNumber != null)
		{
			throw new InputErrorException("Please check your Phone Number");
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequestDto, customer);
		Customer savedCustomer =  customerRepository.save(customer);
		if(savedCustomer != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<CustomerResponseDto> getCustomerDetails() 
	{

		List<CustomerResponseDto> customerResponseDto = new ArrayList<>();
		Iterator iterator = customerRepository.findAll().iterator();
		while(iterator.hasNext())
		{
			CustomerResponseDto customerResponseDtos = new CustomerResponseDto();
			BeanUtils.copyProperties(iterator.next(),customerResponseDtos);
			customerResponseDto.add(customerResponseDtos);
		}
		return customerResponseDto;
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<CustomerResponseDto> getCustomerDetails(String customerName) {

		List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
		List<Customer> customerList = customerRepository.findByCustomerName(customerName);
		for(Customer customer : customerList)
		{
			CustomerResponseDto customerResponseDto = new CustomerResponseDto();
			BeanUtils.copyProperties(customer, customerResponseDto);
			customerResponseDtoList.add(customerResponseDto);
		}
		return customerResponseDtoList;
	}

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public CustomerResponseDto getCustomerDetails(Integer customerId) {

		Customer customer = new Customer();
		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		Optional<Customer> optionalCustomers = customerRepository.findById(customerId);
		if(optionalCustomers.isPresent())
		{
			customer = optionalCustomers.get();
		}
		BeanUtils.copyProperties(customer, customerResponseDto);
		return customerResponseDto;
	}
	
	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<CustomerResponse> findCustomerDetailsByEmailId(String emailAddress) {
		return customerRepository.findByEmailAddress(emailAddress);
	}
	
	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public boolean updateCustomerDetails(Integer customerId, CustomerRequestDto customerRequestDto) {

		Customer customer=customerRepository.findById(customerId).get();
		BeanUtils.copyProperties(customerRequestDto, customer);
		Customer savedCustomer =  customerRepository.save(customer);
		if(savedCustomer != null)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public void deleteCustomerDetails(Integer customerId) 
	{
		Customer customer = customerRepository.findById(customerId).get();
		customerRepository.deleteById(customerId);	
	}
}
