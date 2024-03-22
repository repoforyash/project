package com.cognizant.banking.tests.services;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.banking.repositories.LoanAppDetailMasterRepository;
import com.cognizant.banking.service.LoanAppDetailMasterServiceImpl;


public class TestLoanAppDetailMaster {

	@Mock
	private LoanAppDetailMasterRepository loanAppRepository;
	
	@InjectMocks
	private LoanAppDetailMasterServiceImpl loanAppServiceImpl;
	
	//private LoanApplication loan;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	

	
	
}
