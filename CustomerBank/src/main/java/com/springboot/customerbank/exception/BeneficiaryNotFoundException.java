package com.springboot.customerbank.exception;

public class BeneficiaryNotFoundException extends RuntimeException
{
	
	private static final long serialVersionUID=1L;
	
	public BeneficiaryNotFoundException(String message)
	{
		super(message);
	}

}