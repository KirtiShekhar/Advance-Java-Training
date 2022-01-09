package com.springboot.customerbank.exception;

public class AccountNotFoundException extends RuntimeException   {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		super(message);
	}

}