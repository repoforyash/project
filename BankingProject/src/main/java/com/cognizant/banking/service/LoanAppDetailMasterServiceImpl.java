package com.cognizant.banking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.banking.dto.LoanAppDetailMasterDTO;
import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.dto.ReducedPaymentDTO;
import com.cognizant.banking.entities.LoanAppDetailMaster;
import com.cognizant.banking.entities.LoanApplication;
import com.cognizant.banking.exceptions.LoanApplicationNotFoundException;
import com.cognizant.banking.repositories.LoanAppDetailMasterRepository;
import com.cognizant.banking.utilities.GenerateLoanID;
import com.cognizant.banking.utilities.LoanApplicationValidation;

@Service
public class LoanAppDetailMasterServiceImpl implements  LoanAppDetailMasterService{

	@Autowired
	private LoanAppDetailMasterRepository   loanAppDetailMasterRepository ;
	
	
	@Override
    public List<ReducedPaymentDTO> calculateReducedPaymentList(String loanAppId) {
		
      
        // Retrieve data or calculate the reduced payment for each loan application
        List<LoanAppDetailMaster> loanApps =  loanAppDetailMasterRepository.findByLoanApplicationLoanAppId(loanAppId); 
        List<ReducedPaymentDTO> reducedPaymentDTOList = new ArrayList<>();
        //List<Integer> reducedPaymentList = new ArrayList<>();
        
        for (LoanAppDetailMaster loanApp : loanApps) {
        	
        //	int prOutStandingEndOfMon = loanApp.getPrOutStandingEndOfMon(); 
        	ReducedPaymentDTO RPDTO=new ReducedPaymentDTO();
        	 
        	BeanUtils.copyProperties(loanApp,RPDTO);
            
        	reducedPaymentDTOList.add(RPDTO);
           
        }
       // ReducedPaymentDTO reducedPaymentDTO = new ReducedPaymentDTO();
        //reducedPaymentDTO.setReducedPaymentList(reducedPaymentList);

        return reducedPaymentDTOList;
    }
 
	
}
