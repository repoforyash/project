package com.cognizant.banking.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.service.LoanApplicationService;

@RestController
@RequestMapping("/api")

public class LoanApplicationController{
	
	@Autowired
	private LoanApplicationService loanApplicationService;
	
	//running
	@GetMapping("customer/loan/status/{status}")
	public ResponseEntity<List<LoanApplicationDTO>> getLoanApplicationsByStatus(@PathVariable String status) {
		
		List<LoanApplicationDTO> loanApplications = loanApplicationService.getLoanApplicationsByStatus(status);
		
		return new ResponseEntity<>(loanApplications, HttpStatus.OK);
		
	}
	
	@GetMapping("customer/loan/date/{date}")
	public ResponseEntity<List<LoanApplicationDTO>> getLoanApplicationsByDate(@PathVariable Date loanAppDate) {
		
		List<LoanApplicationDTO> loanApplications = loanApplicationService.getLoanApplicationsByDate(loanAppDate);
		
		return new ResponseEntity<>(loanApplications, HttpStatus.OK);
		
	}
	
	//running
	@GetMapping("customer/loan/{loanAppId}")
	public ResponseEntity<LoanApplicationDTO> getLoanApplicationById(@PathVariable String loanAppId) {
		
		LoanApplicationDTO loanApplicationDTO = loanApplicationService.getLoanApplicationById(loanAppId);
		if(loanApplicationDTO != null) {
			return new ResponseEntity<>(loanApplicationDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//running
	@GetMapping("customer/loan/all")
	public ResponseEntity<List<LoanApplicationDTO>> getNewLoanApplications() {
		
		List<LoanApplicationDTO> loanApplications = loanApplicationService.getNewLoanApplications();
		
		return new ResponseEntity<>(loanApplications, HttpStatus.OK);
		
	}
	
	//running
	@PutMapping("customers/loan/{loanAppId}/update")
	public ResponseEntity<LoanApplicationDTO> updateLoanApplication(@PathVariable("loanAppId") String loanAppId, @RequestBody LoanApplicationDTO loanApplicationDTO) {
		
		LoanApplicationDTO updatedLoanApplication = loanApplicationService.updateLoanApplication(loanApplicationDTO);
		
		if(updatedLoanApplication !=null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	//running
	@PutMapping("customers/loan/checkCustomerAcceptanceStatus/{loanAppId}/{action}")
	public ResponseEntity<LoanApplicationDTO> checkCustomerAcceptanceStatus(@PathVariable("loanAppId") String loanAppId, @PathVariable("action") String action) {
		
		LoanApplicationDTO updatedLoanApplicationDTO = loanApplicationService.checkCustomerAcceptanceStatus(loanAppId, action);
		if(updatedLoanApplicationDTO != null) {
			return new ResponseEntity<>(updatedLoanApplicationDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}

