package com.cognizant.banking.utilities;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class GenerateLoanID {

	private static final String PREFIX = "XY";
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	public static String generateLoanId(String loanType) {
		int loanNumber = counter.incrementAndGet();
		return PREFIX + loanType.substring(0,2).toUpperCase() + String.format("%04d", loanNumber);
		
	}
}
