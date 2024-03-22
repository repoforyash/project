package com.cognizant.banking.service;

import java.util.Date;
import java.util.List;
import com.cognizant.banking.dto.LoanApplicationDTO;



public interface LoanApplicationService {


		//return a loan applications based on status
		public List<LoanApplicationDTO> getLoanApplicationsByStatus(String appStatus);
		
		//return a loan applications based on date
		public List<LoanApplicationDTO> getLoanApplicationsByDate(Date loanAppDate);
		
		//return a specific loan application based on ID
		public LoanApplicationDTO getLoanApplicationById(String loanAppId);
			
		//check acceptance status
		//public LoanApplicationDTO checkCustomerAcceptanceStatus(String loanAppId);
		
		//update loan application
		public LoanApplicationDTO updateLoanApplication(LoanApplicationDTO loanAppDTO); 
		
		//return new loan application list
		public List<LoanApplicationDTO> getNewLoanApplications();
		
		//add newloan application
		//public LoanApplicationDTO addLoanApplication(LoanApplicationDTO loanApplicationDTO);
		
		//Accept or Reject Loan approved
		public LoanApplicationDTO checkCustomerAcceptanceStatus(String loanAppId, String action);

		

}


