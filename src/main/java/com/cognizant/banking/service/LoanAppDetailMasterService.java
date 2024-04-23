package com.cognizant.banking.service;

import java.util.List;
import com.cognizant.banking.dto.ReducedPaymentDTO;


public interface LoanAppDetailMasterService {

	public List<ReducedPaymentDTO> calculateReducedPaymentList(String loanAppId);


}
