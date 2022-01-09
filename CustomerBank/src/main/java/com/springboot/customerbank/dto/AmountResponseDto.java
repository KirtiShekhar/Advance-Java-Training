package com.springboot.customerbank.dto;

public class AmountResponseDto 
{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AmountResponseDto(String message) {
		this.message = message;
	}
	
	public AmountResponseDto() {}
	
	

}
