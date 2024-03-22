package com.cognizant.banking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.banking.entities.LoanAppDetailMaster;

@Repository
public interface LoanAppDetailMasterRepository extends CrudRepository<LoanAppDetailMaster,String>  {

	List<LoanAppDetailMaster> findByLoanApplicationLoanAppId(String loanAppId);

}
