package com.springboot.customerbank.service.implementation;

import java.util.Optional;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.customerbank.entity.Account;
import com.springboot.customerbank.dto.BeneficiaryRequestDto;
import com.springboot.customerbank.repository.AccountRepository;
import com.springboot.customerbank.repository.BeneficiaryRepository;
import com.springboot.customerbank.service.BeneficiaryService;
import com.springboot.customerbank.entity.Beneficiary;
import com.springboot.customerbank.exception.AccountNotFoundException;
import com.springboot.customerbank.exception.BeneficiaryNotFoundException;
import com.springboot.customerbank.exception.InputErrorException;

@Service
public class BeneficiaryServiceImplementation implements BeneficiaryService 
{
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public boolean addBeneficiary(@Valid BeneficiaryRequestDto beneficiaryRequestDto) 
	{
		Account account=accountRepository.findByAccountNumberEquals(beneficiaryRequestDto.getAccountNumber());
		Account account1=accountRepository.findByAccountNumberEquals(beneficiaryRequestDto.getBeneficiaryAccount());
		Beneficiary account3=beneficiaryRepository.findBybeneficiaryName(beneficiaryRequestDto.getBeneficiaryName());
        if(account !=null)
        {
        	throw new AccountNotFoundException("Enter the valid account number");
        }
        if(account1 !=null)
        {
        	throw new AccountNotFoundException("Enter the valid beneficiary account number");
        }
        if(account3 !=null)
        {
        	throw new InputErrorException("Check the entered Beneficiary name");
        }
		
		Beneficiary beneficiaryAccount=new Beneficiary();
		BeanUtils.copyProperties(beneficiaryRequestDto, beneficiaryAccount);
		Beneficiary beneficiarySaved =  beneficiaryRepository.save(beneficiaryAccount);
		if(beneficiarySaved!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public List<Beneficiary> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Beneficiary> beneficiaryList = beneficiaryRepository.findAll();
		return beneficiaryList;
	}


	@Transactional(rollbackFor = Exception.class,noRollbackFor = EntityNotFoundException.class)
	public String deleteBeneficiaryData(Integer beneficiaryId) 
	{

		Optional<Beneficiary> optionalbeneficiary = beneficiaryRepository.findById(beneficiaryId);
		if(optionalbeneficiary.isPresent())
		{
			Beneficiary beneficiary=beneficiaryRepository.findByBeneficiaryId(beneficiaryId);
			beneficiaryRepository.delete(beneficiary);
			return "beneficiary Deleted";
		}
		throw new BeneficiaryNotFoundException("Beneficiary not found");
		
	}

}
