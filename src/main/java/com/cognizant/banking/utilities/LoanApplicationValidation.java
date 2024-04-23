package com.cognizant.banking.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.exceptions.LoanUnderProcessingException;
import com.cognizant.banking.repositories.LoanApplicationRepository;

@Component
public class LoanApplicationValidation {
	
	@Autowired
	private LoanApplicationRepository loanRepository;
	
	public LoanApplicationValidation(LoanApplicationRepository loanRepository) {
		this.loanRepository = loanRepository;
	}
	
	public static void validateLoanApplication(LoanApplicationDTO loanApplicationDTO){
		
		LocalDate loanApplicationDate = loanApplicationDTO.getLoanAppDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(!Arrays.asList("newloan", "cancelled", "approved", "sanctioned").contains(loanApplicationDTO.getAppStatus().toLowerCase())) {
			throw new IllegalArgumentException("LoanException: Cannot update loan record. Application status is not Valid.");
		}
		
		if(!(loanApplicationDTO.getLoanAmt()>=0)) {
			throw new IllegalArgumentException("InvalidAmountException: Amount should be positive.");
		}
		
		if(!loanApplicationDate.equals(LocalDate.now())){
			throw new IllegalArgumentException("InvalidLoanAppDateException: Loan app date should be current date");
		}
		
		if(!Arrays.asList("accepted", "rejected", "no status").contains(loanApplicationDTO.getStatus().toLowerCase())){
			throw new IllegalArgumentException("LoanUpdateException:Cannot update loan application. Application status is not matching.");
		}
		
	}

	//updating loan application only if app status is new loan 
	public static void validateUpdate(LoanApplicationDTO loanApplicationDTO){
		
		if(!loanApplicationDTO.getAppStatus().equalsIgnoreCase("NewLoan")) {
			throw new LoanUnderProcessingException("LoanUnderProcessingException: Cannot update loan record. Application status is not New.");
		}
		
	}


	//Changing status of Loan to accepted or rejected ONLY if AppStatus is Approved
	public static void validateStatusChange(LoanApplicationDTO loanApplicationDTO) throws Exception{
	
		if(!loanApplicationDTO.getAppStatus().equalsIgnoreCase("Approved")) {
			throw new IllegalArgumentException("InvalidStatusChangeException:Cannot change status. Application status is not Approved.");
		}
	}
}

