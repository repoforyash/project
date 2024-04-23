package com.cognizant.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.banking.dto.CustomerMasterDTO;
import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.service.LoanApplicationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class LoanApplicationController{
	
	@Autowired
	private LoanApplicationService loanApplicationService;
	
	@PostMapping("customers/loan/new")
	public ResponseEntity<LoanApplicationDTO> addLoanApplication(@RequestBody LoanApplicationDTO loanApplicationDTO) {
		System.out.println("loanApplicationDTOloanApplicationDTO->"+loanApplicationDTO);
		log.info("Add a new loan application");
		LoanApplicationDTO addedLoanApplication = loanApplicationService.addLoanApplication(loanApplicationDTO);
		
		if(addedLoanApplication!= null) {
			return new ResponseEntity<>(HttpStatus.CREATED); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@GetMapping("customers/loan/status/{status}")
	public ResponseEntity<List<LoanApplicationDTO>> getLoanApplicationsByStatus(@PathVariable("status") String status) {
		
		log.info("Get all the customers based on loan application status");
		List<LoanApplicationDTO> loanApplications = loanApplicationService.getLoanApplicationsByStatus(status);
		
		return new ResponseEntity<List<LoanApplicationDTO>>(loanApplications, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("customers/loan/{loanAppId}")
	public ResponseEntity<LoanApplicationDTO> getLoanApplicationById(@PathVariable String loanAppId) {
		
		log.info("Get all the customers based on loan app ID");
		LoanApplicationDTO loanApplicationDTO = loanApplicationService.getLoanApplicationById(loanAppId);
		if(loanApplicationDTO != null) {
			return new ResponseEntity<>(loanApplicationDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("customers/loan/all")
	public ResponseEntity<List<LoanApplicationDTO>> getNewLoanApplications() {
		
		log.info("Get all the customers who have taken/applied for a loan");
		List<LoanApplicationDTO> loanApplications = loanApplicationService.getNewLoanApplications();
		
		return new ResponseEntity<>(loanApplications, HttpStatus.OK);
		
	}
	
	
	@PutMapping("customers/loan/{loanAppId}/update")
	public ResponseEntity<LoanApplicationDTO> updateLoanApplication(@PathVariable("loanAppId") String loanAppId, @RequestBody LoanApplicationDTO loanApplicationDTO) {
		
		log.info("Update the details of loan application a customer based on loan app ID");
		LoanApplicationDTO updatedLoanApplication = loanApplicationService.updateLoanApplication(loanApplicationDTO);
		
		if(updatedLoanApplication !=null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	
	@PutMapping("customers/loan/checkCustomerAcceptanceStatus/{loanAppId}/{action}")
	public ResponseEntity<LoanApplicationDTO> checkCustomerAcceptanceStatus(@PathVariable("loanAppId") String loanAppId, @PathVariable("action") String action) {
		
		log.info("Update the Status of applied loan status if the App status is Approved");
		LoanApplicationDTO updatedLoanApplicationDTO = loanApplicationService.checkCustomerAcceptanceStatus(loanAppId, action);
		if(updatedLoanApplicationDTO != null) {
			return new ResponseEntity<>(updatedLoanApplicationDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}

