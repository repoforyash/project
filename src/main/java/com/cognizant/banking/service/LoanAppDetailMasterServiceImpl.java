package com.cognizant.banking.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.banking.dto.ReducedPaymentDTO;
import com.cognizant.banking.entities.LoanAppDetailMaster;
import com.cognizant.banking.repositories.LoanAppDetailMasterRepository;

@Service
public class LoanAppDetailMasterServiceImpl implements  LoanAppDetailMasterService{

	@Autowired
	private LoanAppDetailMasterRepository   loanAppDetailMasterRepository ;
	
	
	@Override
    public List<ReducedPaymentDTO> calculateReducedPaymentList(String loanAppId) {
		      
        List<LoanAppDetailMaster> loanApps =  loanAppDetailMasterRepository.findByLoanApplicationLoanAppId(loanAppId); 
        List<ReducedPaymentDTO> reducedPaymentDTOList = new ArrayList<>();
      
        for (LoanAppDetailMaster loanApp : loanApps) {
        	   
        	ReducedPaymentDTO RPDTO=new ReducedPaymentDTO();       	 
        	BeanUtils.copyProperties(loanApp,RPDTO);           
        	reducedPaymentDTOList.add(RPDTO);
           
        }
        return reducedPaymentDTOList;
    }
 
	
}
