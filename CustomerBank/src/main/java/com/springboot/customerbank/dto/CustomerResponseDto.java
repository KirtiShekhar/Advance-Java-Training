package com.springboot.customerbank.dto;

import java.io.Serializable;
import java.util.List;

import com.springboot.customerbank.entity.Address;

public class CustomerResponseDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String customerName;
	private String contactNumber;
	private String emailAddress;
	private List<Address> address;
	
	public CustomerResponseDto() {}

	public CustomerResponseDto(Integer customerId, String customerName, String contactNumber, String emailAddress,
			List<Address> address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

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
	
}