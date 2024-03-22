package com.cognizant.banking.repositories;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.banking.entities.LoanApplication;


@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication,String>{

	List<LoanApplication> findByAppStatus(String appStatus);

	List<LoanApplication> findByLoanAppDate(Date loanAppDate);

	Optional<LoanApplication> findByLoanAppId(String loanAppId);
	
}
