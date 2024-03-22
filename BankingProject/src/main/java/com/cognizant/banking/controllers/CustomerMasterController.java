package com.cognizant.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.banking.dto.CustomerMasterDTO;
import com.cognizant.banking.service.CustomerMasterService;

@RestController
@RequestMapping("/api")
public class CustomerMasterController {
	
	public CustomerMasterController() {
		
	}

		@Autowired	
		private CustomerMasterService customerMasterService;
		
		//running
		@PostMapping("customers/new")
		public ResponseEntity<CustomerMasterDTO> addCustomer(@RequestBody CustomerMasterDTO customerMasterDTO) {
			
			CustomerMasterDTO addedCustomer = customerMasterService.addCustomer(customerMasterDTO);
			if(addedCustomer!= null) {
				return new ResponseEntity<>(HttpStatus.CREATED); 
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			
		}
		
		//running
		@GetMapping("customers")
		public ResponseEntity<List<CustomerMasterDTO>> getAllCustomers() {
			
			List<CustomerMasterDTO> customers = customerMasterService.getAllCustomers();
			ResponseEntity<List<CustomerMasterDTO>> reponseEntity = null;
			if(!customers.isEmpty()) {
				reponseEntity =  new ResponseEntity<List<CustomerMasterDTO>>(customers,HttpStatus.OK);
			}
			else {
				reponseEntity =  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return reponseEntity;
		}
		
		//running
		@PutMapping("customers/{custId}/update")
		public ResponseEntity<CustomerMasterDTO> updateCustomer(@PathVariable String custId, @RequestBody CustomerMasterDTO customerDTO) {
			customerDTO.setCustId(custId);
			CustomerMasterDTO updatedCustomer = customerMasterService.updateCustomer(custId, customerDTO);
			if(updatedCustomer !=null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		//running
		@GetMapping("customers/{custId}")
		public ResponseEntity<CustomerMasterDTO> getCustomerById(@PathVariable String custId){
			
			CustomerMasterDTO customerDTO = customerMasterService.getCustomerById(custId);
			if(customerDTO != null) {
				return new ResponseEntity<CustomerMasterDTO>(customerDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
}

