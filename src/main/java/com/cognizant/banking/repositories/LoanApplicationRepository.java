package com.cognizant.banking.repositories;


import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.banking.entities.LoanApplication;


@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication,String>{

	List<LoanApplication> findByAppStatus(String appStatus);

	List<LoanApplication> findByLoanAppDate(Date loanAppDate);

	List<LoanApplication> findByStatus(String appStatus);
	
}
