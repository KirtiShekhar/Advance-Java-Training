package com.springboot.customerbank.dto;

import java.time.LocalDate;

public class TransactionRequestDateDto 
{
	private LocalDate fromDate;
	private LocalDate toDate;
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	
	
}
