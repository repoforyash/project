package com.cognizant.banking.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cognizant.banking.dto.LoanAppDetailMasterDTO;
import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.dto.ReducedPaymentDTO;
import com.cognizant.banking.entities.LoanAppDetailMaster;

public interface LoanAppDetailMasterService {
	

	//return reduced payment list
	public List<ReducedPaymentDTO> calculateReducedPaymentList(String loanAppId);


}
