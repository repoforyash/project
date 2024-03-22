package com.cognizant.banking.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.entities.LoanApplication;
import com.cognizant.banking.exceptions.LoanApplicationNotFoundException;
import com.cognizant.banking.exceptions.ResourceNotFoundException;
import com.cognizant.banking.repositories.LoanApplicationRepository;
import com.cognizant.banking.utilities.GenerateLoanID;

import com.cognizant.banking.utilities.LoanApplicationValidation;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService{

	@Autowired
	private LoanApplicationRepository   loanApplicationRepository ;
	
	
	public LoanApplicationServiceImpl(LoanApplicationRepository loanApplicationRepository) {
		this.loanApplicationRepository = loanApplicationRepository;
		
	}
	
	//Get New Loan Applications
	@Override
	public List<LoanApplicationDTO> getNewLoanApplications() {
		//fetching loan applications from repository
		List<LoanApplication> loanApplications = loanApplicationRepository.findByAppStatus("NewLoan");
		//convert entity to dto
		//System.out.println(loanApplications);
		List<LoanApplicationDTO> loanApplicationDTOs = new ArrayList<>();
		
		for(LoanApplication loanApplication : loanApplications) {
			
			LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
			
			BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
			loanApplicationDTOs.add(loanApplicationDTO);
			}
		return loanApplicationDTOs;      
		
	}
	
	
	
	
	//Add Loan Application
//	@Override
//	public LoanApplicationDTO addLoanApplication(LoanApplicationDTO loanApplicationDTO) {
//	
//		String loanId = GenerateLoanID.generateLoanId(loanApplicationDTO.getTypeOfLoan());
//		
//		loanApplicationDTO.setLoanAppId(loanId);
//		loanApplicationDTO.setLoanAppDate(new Date());
//		
//		//validate
//		
//			LoanApplicationValidation.validateLoanApplication(loanApplicationDTO);
//		
//		
//		//convert dto to entity
//		LoanApplication loanApplication = new LoanApplication();
//		BeanUtils.copyProperties(loanApplicationDTO, loanApplication);
//		
//		//save the loan application
//		loanApplication = loanApplicationRepository.save(loanApplication);
//
//		//convert back to dto then return
//		LoanApplicationDTO savedLoanApplicationDTO = new LoanApplicationDTO();
//		BeanUtils.copyProperties(loanApplication, savedLoanApplicationDTO);
//		return savedLoanApplicationDTO;
//		}
	
	
	
	//Return loan applications based on Status
		@Override
		public List<LoanApplicationDTO> getLoanApplicationsByStatus(String appStatus) {
			
			List<LoanApplication> loanApplications  = loanApplicationRepository.findByAppStatus(appStatus);
			
			List<LoanApplicationDTO> loanApplicationDTOs = new ArrayList<>();
			
			for(LoanApplication loanApplication : loanApplications) {
				
				LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
				BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
				loanApplicationDTOs.add(loanApplicationDTO);
				
			}
			return loanApplicationDTOs;
		}

		//Return loan applications based on Date
				@Override
				public List<LoanApplicationDTO> getLoanApplicationsByDate(Date loanAppDate) {
					
					List<LoanApplication> loanApplications  = loanApplicationRepository.findByLoanAppDate(loanAppDate);
					
					List<LoanApplicationDTO> loanApplicationDTOs = new ArrayList<>();
					
					for(LoanApplication loanApplication : loanApplications) {
						
						LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
						BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
						loanApplicationDTOs.add(loanApplicationDTO);
						
					}
					return loanApplicationDTOs;
				}
	
				//Return loan applications based on Date
				@Override
				public LoanApplicationDTO getLoanApplicationById(String loanAppId) {
					
					Optional<LoanApplication> optionalLoanApplication  = loanApplicationRepository.findByLoanAppId(loanAppId);
					
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
		
		//update loan application
		@Override
		public LoanApplicationDTO updateLoanApplication(LoanApplicationDTO loanAppDTO) {

			//validate
				LoanApplicationValidation.validateUpdate(loanAppDTO);
		
			//check if the application exists
			Optional<LoanApplication> optionalLoanApplication = loanApplicationRepository.findById(loanAppDTO.getLoanAppId());
			if(optionalLoanApplication.isPresent()) {
				LoanApplication loanApplication = optionalLoanApplication.get();
				
				//update the properties
				BeanUtils.copyProperties(loanAppDTO, loanApplication);
				
				//save
				LoanApplication updatedLoanApplication = loanApplicationRepository.save(loanApplication);
				
				
				//convert and return the updated loan application DTO
				LoanApplicationDTO updatedLoanAppDTO = new LoanApplicationDTO();
				BeanUtils.copyProperties(updatedLoanApplication, updatedLoanAppDTO);
				return updatedLoanAppDTO;
			}else {
				throw new LoanApplicationNotFoundException("Loan Application with ID: "+ loanAppDTO.getLoanAppId() + " not found");
			}
			
				
		}

	
		//check customer acceptance status
//		@Override
//		public LoanApplicationDTO checkCustomerAcceptanceStatus(String loanAppId) {
//			
//			Optional<LoanApplication> optionalLoanApplication  = loanApplicationRepository.findByLoanAppId(loanAppId);
//			
//			if(optionalLoanApplication.isPresent()) {
//				LoanApplication loanApplication = optionalLoanApplication.get();
//				LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
//				BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
//				
//				if("accepted".equalsIgnoreCase(loanApplication.getAppStatus())) {
//					loanApplicationDTO.setStatus("Accepted");
//				}else if("rejected".equalsIgnoreCase(loanApplication.getAppStatus())) {
//					loanApplicationDTO.setStatus("Rejected");
//				}
//				else {
//					loanApplicationDTO.setStatus("No Status");
//				}
//
//			return loanApplicationDTO;
//		}	
//			else {
//				throw new LoanApplicationNotFoundException("Loan Application not found with ID: " +loanAppId);
//			}
//		}
	
	
	

	//Accept or Reject Loan Application
	@Override
	public LoanApplicationDTO checkCustomerAcceptanceStatus(String loanAppId, String action) {

		
		Optional<LoanApplication> optionalLoanApplication = loanApplicationRepository.findById(loanAppId);
		if(optionalLoanApplication.isPresent()) {
			
		
			LoanApplication loanApplication = optionalLoanApplication.get();
			
			LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
			BeanUtils.copyProperties(loanApplication, loanApplicationDTO);
			
			//validate
			try {
				LoanApplicationValidation.validateStatusChange(loanApplicationDTO);
			} catch (Exception e) {
				
			}
			
				if("accepted".equalsIgnoreCase(action)) {
					//perform actions for acceptance
					loanApplication.setStatus("Accepted");
				}
				else if("rejected".equalsIgnoreCase(action)) {
					//perform actions for rejection
					loanApplication.setStatus("Rejected");
				}
				else if("nostatus".equalsIgnoreCase(action)) {
					//perform actions for rejection
					loanApplication.setStatus("No Status");
				}
				else {
					throw new IllegalArgumentException("Invalid action: "+ action);
				}
				//save the updated loan application
				LoanApplication updatedLoanApplication = loanApplicationRepository.save(loanApplication);
				
				//convert entity to dto
				loanApplicationDTO = new LoanApplicationDTO();
				BeanUtils.copyProperties(updatedLoanApplication, loanApplicationDTO);
				
				return loanApplicationDTO;
			
		}
			else {
				throw new ResourceNotFoundException("Loan application not found with ID: "+ loanAppId);
			}
					
		}
		
		
}


