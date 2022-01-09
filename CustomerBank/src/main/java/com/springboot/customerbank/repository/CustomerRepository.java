package com.springboot.customerbank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.customerbank.dto.CustomerResponse;
import com.springboot.customerbank.entity.Customer;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> 
{
	List<Customer> findByCustomerName(String customerName);
	
	@Query("SELECT new com.springboot.customerbank.dto.CustomerResponse(a.contactNumber, a.emailAddress) FROM Customer a WHERE a.emailAddress = :emailAddress")
	List<CustomerResponse> findByEmailAddress(String emailAddress);
	
	Customer findByContactNumber(String contactNumber);
}