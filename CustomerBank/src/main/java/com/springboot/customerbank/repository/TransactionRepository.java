package com.springboot.customerbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.customerbank.entity.Transaction;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> 
{
	List<Transaction> findByAccountid(Integer accountid);

	@Query("select t from Transaction t where transactionDate BETWEEN :x AND :y")
	List<Transaction> findTransactionByDate(@Param("x")LocalDate fromDate,@Param("y")LocalDate toDate);

}