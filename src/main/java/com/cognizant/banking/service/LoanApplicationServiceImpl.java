package com.cognizant.banking.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.banking.dto.CustomerMasterDTO;
import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.entities.CustomerMaster;
import com.cognizant.banking.entities.LoanApplication;
import com.cognizant.banking.exceptions.LoanApplicationNotFoundException;
import com.cognizant.banking.exceptions.ResourceNotFoundException;
import com.cognizant.banking.repositories.CustomerMasterRepository;
import com.cognizant.banking.repositories.LoanApplicationRepository;
import com.cognizant.banking.utilities.CustomerValidation;
import com.cognizant.banking.utilities.GenerateCustomerID;
import com.cognizant.banking.utilities.GenerateLoanID;
import com.cognizant.banking.utilities.LoanApplicationValidation;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService{

	@Autowired
	private LoanApplicationRepository   loanApplicationRepository ;
	
	@Autowired
	private CustomerMasterRepository customerMasterRepository;
	
	public LoanApplicationServiceImpl(LoanApplicationRepository loanApplicationRepository) {
		this.loanApplicationRepository = loanApplicationRepository;
		
	}
	
	@Override
	public List<LoanApplicationDTO> getNewLoanApplications() {
		
		List<LoanApplication> loanApplications = loanApplicationRepository.findByAppStatus("NewLoan");		
		List<LoanApplicationDTO> loanApplicationDTOs = new ArrayList<>();
		
		for(LoanApplication loanApplication : loanApplications) {
			
			LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();		
			BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
			loanApplicationDTOs.add(loanApplicationDTO);
			}
		return loanApplicationDTOs;      
		
	}
	
	
	@Override
	public LoanApplicationDTO addLoanApplication(LoanApplicationDTO loanAppDTO) {
		
		LoanApplicationValidation loanValidation=new LoanApplicationValidation(loanApplicationRepository);
		loanValidation.validateLoanApplication(loanAppDTO); 
		String loanAppID = GenerateLoanID.generateLoanId(loanAppDTO.getTypeOfLoan()); //generate ID
		loanAppDTO.setLoanAppId(loanAppID); 
		
		LoanApplication loanApplication = new LoanApplication();
		
			BeanUtils.copyProperties(loanAppDTO, loanApplication);
			
			CustomerMaster customerMaster=customerMasterRepository.findById(loanAppDTO.getCustId()).get();
			loanApplication.setCustomerMaster(customerMaster);
			
			LoanApplication savedLoanApplication = loanApplicationRepository.save(loanApplication);
			LoanApplicationDTO savedLoanApplicationDTO = new LoanApplicationDTO();
			BeanUtils.copyProperties(savedLoanApplication, savedLoanApplicationDTO);
		
			return savedLoanApplicationDTO;
		
	}
	
	
	@Override
	public LoanApplicationDTO getLoanApplicationById(String loanAppId) {
				
		Optional<LoanApplication> optionalLoanApplication  = loanApplicationRepository.findById(loanAppId);
				
	  	if(optionalLoanApplication.isPresent()) {
	  		
					LoanApplication loanApplication = optionalLoanApplication.get();
					LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
					BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
				    return loanApplicationDTO;
			}	
			else {
					throw new LoanApplicationNotFoundException("Loan Application not found with ID: " +loanAppId);
			}
	}
	

		@Override
		public List<LoanApplicationDTO> getLoanApplicationsByStatus(String appStatus) {
			
			List<LoanApplication> loanApplications  = loanApplicationRepository.findByStatus(appStatus);		
			List<LoanApplicationDTO> loanApplicationDTOs = new ArrayList<>();
			
			for(LoanApplication loanApplication : loanApplications) {
				
				LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
				BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
				loanApplicationDTOs.add(loanApplicationDTO);
				
			}
			return loanApplicationDTOs;
		}
	
		
	
		@Override
		public LoanApplicationDTO updateLoanApplication(LoanApplicationDTO loanAppDTO) {
		
			LoanApplicationValidation.validateUpdate(loanAppDTO);
			
			Optional<LoanApplication> optionalLoanApplication = loanApplicationRepository.findById(loanAppDTO.getLoanAppId());
			if(optionalLoanApplication.isPresent()) {
				
				LoanApplication loanApplication = optionalLoanApplication.get();			
				BeanUtils.copyProperties(loanAppDTO, loanApplication);
				
				LoanApplication updatedLoanApplication = loanApplicationRepository.save(loanApplication);				
				LoanApplicationDTO updatedLoanAppDTO = new LoanApplicationDTO();
				BeanUtils.copyProperties(updatedLoanApplication, updatedLoanAppDTO);
				
				return updatedLoanAppDTO;
				
			}else {
				throw new LoanApplicationNotFoundException("Loan Application with ID: "+ loanAppDTO.getLoanAppId() + " not found");
			}
			
				
		}


	
	@Override
	public LoanApplicationDTO checkCustomerAcceptanceStatus(String loanAppId, String action) {
	
		Optional<LoanApplication> optionalLoanApplication = loanApplicationRepository.findById(loanAppId);
		if(optionalLoanApplication.isPresent()) {
					
			LoanApplication loanApplication = optionalLoanApplication.get();			
			LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
			BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
			
			
			try {
				LoanApplicationValidation.validateStatusChange(loanApplicationDTO);
			} catch (Exception e) {
				
			}
			
				if("accepted".equalsIgnoreCase(action)) {
					
					loanApplication.setStatus("Accepted");
				}
				else if("rejected".equalsIgnoreCase(action)) {
			
					loanApplication.setStatus("Rejected");
				}
				else if("nostatus".equalsIgnoreCase(action)) {
					
					loanApplication.setStatus("No Status");
				}
				else {
					throw new IllegalArgumentException("Invalid action: "+ action);
				}
			
				LoanApplication updatedLoanApplication = loanApplicationRepository.save(loanApplication);
				
				loanApplicationDTO = new LoanApplicationDTO();
				BeanUtils.copyProperties(updatedLoanApplication, loanApplicationDTO);
				
				return loanApplicationDTO;
			
		}
			else {
				throw new ResourceNotFoundException("Loan application not found with ID: "+ loanAppId);
			}
					
		}

	
		
		
}


