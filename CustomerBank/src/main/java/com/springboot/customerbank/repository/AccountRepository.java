package com.springboot.customerbank.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.springboot.customerbank.dto.AccountResponseDto;
import com.springboot.customerbank.dto.AccountResponse;
import com.springboot.customerbank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> 
{
	AccountResponseDto findByAccountNumber(long accountNumber);
	
	@Query(value = "select new com.springboot.customerbank.dto.AccountResponse(a.accountId,a.accountNumber) from Account a")
	List<AccountResponse> findByAccount();
	
	Account findByCustomerId(Integer customerId);
	
	Optional<Account> findByAccountNumber(Long fromAccountNumber);
	
	Account findByAccountNumberEquals(Long fromAccountNumber);
}