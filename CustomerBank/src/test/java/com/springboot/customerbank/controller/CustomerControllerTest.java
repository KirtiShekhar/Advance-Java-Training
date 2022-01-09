package com.springboot.customerbank.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springboot.customerbank.service.CustomerService;
import com.springboot.customerbank.dto.CustomerRequestDto;
import com.springboot.customerbank.dto.CustomerResponse;
import com.springboot.customerbank.dto.CustomerResponseDto;
import com.springboot.customerbank.entity.Address;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest 
{
	@Mock
	CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	CustomerRequestDto customerRequestDto;
	CustomerResponseDto customerResponseDto;
	List<Address> addresses,addresses1;
	//Customer customer;
	
	
	@BeforeEach
	public void setUp()
	{
		addresses = new ArrayList<Address>();
		addresses1 = new ArrayList<Address>();
		addresses.add(new Address(1,"Haryana","Gurugram",110093L,"Current"));
		addresses.add(new Address(2,"New Delhi","Dilshad Colony",110095L,"Permanent"));
		addresses1.add(new Address(3,"Uttar Pradesh","Allahabad",520152L,"Current"));
		addresses1.add(new Address(4,"New Delhi","Janakpuri",110096L,"Permanent"));
		
		customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setCustomerName("Nidhi Updhyay");
		customerRequestDto.setEmailAddress("nidhiup@gmail.com");
		customerRequestDto.setContactNumber("9864517852");
		customerRequestDto.setAddress(addresses);
		
		
		customerResponseDto= new CustomerResponseDto();
		customerResponseDto.setCustomerId(2);
		customerResponseDto.setCustomerName("Chandra Shekhar Pandey");
		customerResponseDto.setEmailAddress("cspandey@gmail.com");
		customerResponseDto.setContactNumber("9814542633");
		//customerResponseDto.setAddress(addresses1);
		/*
		 * customer = new Customer(); customer.setCustomerName("");
		 */
	}
	

	@Test
	@DisplayName("Save Customer Details : Positive")
	void SaveCustomerDetailsTest_Positive() 
	{
		// context
		when(customerService.saveCustomerDetails(customerRequestDto)).thenReturn(true);
		//event
		ResponseEntity<String> customersaveresult = customerController.saveCustomerDetails(customerRequestDto);
		//outcome
		assertEquals("Customer Details Saved Successfully", customersaveresult.getBody());
		assertEquals(HttpStatus.ACCEPTED, customersaveresult.getStatusCode());
	}
	
	@Test
	@DisplayName("Save Customer Details : Negative")
	void SaveCustomerDetailsTest_Negative() 
	{
		// context
		when(customerService.saveCustomerDetails(customerRequestDto)).thenReturn(false);
		//event
		ResponseEntity<String> customersaveresult = customerController.saveCustomerDetails(customerRequestDto);
		//outcome
		assertEquals("Customer Details Saved Unsuccessfully", customersaveresult.getBody());
		assertEquals(HttpStatus.BAD_REQUEST, customersaveresult.getStatusCode());
	}

	@Test 
	@DisplayName("Get All Customer Details") 
	void GetAllCustomerDetailsTest() 
	{
		//context
		when(customerService.getCustomerDetails()).thenReturn(Stream.of(new CustomerResponseDto(1, "Manas Singh", "9718363417", "manassingh@gmail.com", addresses),new CustomerResponseDto(1, "Shilpi Upadhyay", "9475152455", "shilpiupadhyay@gmail.com", addresses1)).collect(Collectors.toList()));
		//event 
		List<CustomerResponseDto> customerdetails = customerController.getCustomerDetails(); 
		//outcome 
		assertEquals(2,customerdetails.size()); 
	}
	
	@Test 
	@DisplayName("Get All Customers on Given EmailId") 
	void CustomerDetailsByEmailIDTest() 
	{
		// context  CustomerResponse(String emailAddress, String contactNumber)
		when(customerService.findCustomerDetailsByEmailId("nidhiup@gmail.com")).thenReturn(Stream.of(new CustomerResponse("nidhiup@gmail.com","9975463211")).collect(Collectors.toList()));
		//event 
		List<CustomerResponse> customerEmailDetails = customerController.getCustomerDetailsByEmailID("nidhiup@gmail.com");
		//outcome
		assertEquals(1, customerEmailDetails.size());
	}

	@Test 
	@DisplayName("Get All Customers on Given CustomerId") 
	void CustomerDetailsByNameTest() 
	{
		// context  CustomerResponse(String emailAddress, String contactNumber)
		when(customerService.getCustomerDetails(2)).thenReturn(customerResponseDto);
		//event 
		CustomerResponseDto customerDetailsById = customerController.getCustomerDetails(2);
		//outcome
		assertEquals(customerResponseDto, customerDetailsById);
	}

}
