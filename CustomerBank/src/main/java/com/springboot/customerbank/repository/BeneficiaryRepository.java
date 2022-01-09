package com.springboot.customerbank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.customerbank.entity.Beneficiary;


@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> 
{
	@Query(value = "select a from Beneficiary a where accountNumber =:x AND beneficiaryAccount =:y" )
	Optional<Beneficiary> findByAccountNumber(@Param("x")Long accountNumber,@Param("y")Long beneficiaryAccount);
	
	Beneficiary findByBeneficiaryId(Integer beneficiaryId);
	
	Beneficiary findBybeneficiaryName(String beneficiaryName);
}
