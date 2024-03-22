package com.cognizant.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.banking.dto.ReducedPaymentDTO;
import com.cognizant.banking.service.LoanAppDetailMasterService;

@RestController
@RequestMapping("/api")
public class LoanAppDetailMasterController {

	@Autowired
	private LoanAppDetailMasterService loanAppDetailMasterService;
	
	@GetMapping("loanapps/recievesanctionAmount/{loanAppId}")
	public ResponseEntity<List<ReducedPaymentDTO>> calculateReducedPaymentList(@PathVariable String loanAppId) {
		
		List<ReducedPaymentDTO> reducedPayment = loanAppDetailMasterService.calculateReducedPaymentList(loanAppId);
		
		return new ResponseEntity<List<ReducedPaymentDTO>>(reducedPayment, HttpStatus.OK);
		
	}
	
}
