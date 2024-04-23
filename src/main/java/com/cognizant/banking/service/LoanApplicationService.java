package com.cognizant.banking.service;

import java.util.List;
import com.cognizant.banking.dto.LoanApplicationDTO;



public interface LoanApplicationService {

		public LoanApplicationDTO addLoanApplication(LoanApplicationDTO loanAppDTO);

		public List<LoanApplicationDTO> getLoanApplicationsByStatus(String appStatus);
		
		public LoanApplicationDTO getLoanApplicationById(String loanAppId);

		public LoanApplicationDTO updateLoanApplication(LoanApplicationDTO loanAppDTO); 

		public List<LoanApplicationDTO> getNewLoanApplications();

		public LoanApplicationDTO checkCustomerAcceptanceStatus(String loanAppId, String action);
	

}


