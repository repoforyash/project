package com.cognizant.banking.utilities;

import org.springframework.stereotype.Component;

@Component
public class GenerateLoanID {
	
	public static String generateLoanId(String loanType) {
		
		int loanNumber = (int) (Math.random() * 9000) + 1000;
		String initials = loanType.substring(0,2).toUpperCase();
		
		return  initials + loanNumber;
		
	}
}
