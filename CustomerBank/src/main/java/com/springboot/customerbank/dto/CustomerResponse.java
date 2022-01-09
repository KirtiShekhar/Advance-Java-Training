package com.springboot.customerbank.dto;


public class CustomerResponse 
{
	private String emailAddress;
	private String contactNumber;
	
	public CustomerResponse(String emailAddress, String contactNumber) {
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	

}
