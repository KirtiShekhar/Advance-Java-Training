package com.springboot.customerbank.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.springboot.customerbank.service.implementation.CustomerServiceImplementation;
import com.springboot.customerbank.dto.CustomerRequestDto;
import com.springboot.customerbank.repository.CustomerRepository;
import com.springboot.customerbank.entity.Address;
import com.springboot.customerbank.entity.Customer;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplementationTest 
{
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImplementation customerServiceImplementation;
	
	CustomerRequestDto customerRequestDto;
	Customer customer;
	List<Address> addresses;
	
	
	@BeforeEach
	public void setUp()
	{
		addresses = new ArrayList<Address>();
		addresses.add(new Address(1,"Haryana","Gurugram",110093L,"Current"));
		addresses.add(new Address(2,"New Delhi","Dilshad Colony",110095L,"Permanent"));
		
		customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setCustomerName("Nidhi Updhyay");
		customerRequestDto.setEmailAddress("nidhiup@gmail.com");
		customerRequestDto.setContactNumber("9864517852");
		customerRequestDto.setAddress(addresses);
		
		 customer = new Customer(); 
		 customer.setCustomerName("Neha Pandey");
		 customer.setEmailAddress("neha@gmail.com");
		 customer.setContactNumber("9868396866");
		 customer.setAddress(addresses);
	}
	

	@Test
	@DisplayName("Save Customer Details : Positive")
	void SaveCustomerDetailsTest_Positive() 
	{
		// context
		when(customerRepository.save(any(Customer.class))).thenAnswer(i ->{
			Customer customer = i.getArgument(0);
			customer.setCustomerId(1);
			return customer;
		});
		//event
		boolean customersaveresult = customerServiceImplementation.saveCustomerDetails(customerRequestDto);
		//outcome
		assertTrue(customersaveresult);
	}
	
	@Test
	@DisplayName("Save Customer Details : Negative")
	void SaveCustomerDetailsTest_Negative() 
	{
		// context
		when(customerRepository.save(any(Customer.class))).thenReturn(null);
		//event
		boolean customersaveresult = customerServiceImplementation.saveCustomerDetails(customerRequestDto);
		//outcome
		assertFalse(customersaveresult);
	}
}
