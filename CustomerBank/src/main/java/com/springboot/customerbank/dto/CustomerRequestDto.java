package com.springboot.customerbank.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springboot.customerbank.entity.Address;

public class CustomerRequestDto 
{
	@NotNull(message = "Customer Name cannot be null")
	@NotEmpty(message = "Customer Name cannot be empty")
	private String customerName;
	@NotNull(message = "Contact Number cannot be null")
	@NotEmpty(message = "Contact Number cannot be empty")
	private String contactNumber;
	@NotNull(message = "Email Address  cannot be null")
	@NotEmpty(message = "Email Address  cannot be empty")
	@Email(message = "Enter a valid email id")
	private String emailAddress;
	@NotNull(message = "Address cannot be null")
	@NotEmpty(message = "Address cannot be empty")
	private List<Address> address;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Address> getAddress() {
		return address;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public CustomerRequestDto() {}
	
	public CustomerRequestDto(String customerName, String contactNumber, String emailAddress, List<Address> address) {
		super();
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}
	
}
