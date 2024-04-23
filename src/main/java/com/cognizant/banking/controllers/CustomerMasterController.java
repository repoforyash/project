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
import com.cognizant.banking.service.CustomerMasterService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerMasterController {
	
	public CustomerMasterController() {
		
	}

		@Autowired	
		private CustomerMasterService customerMasterService;
		
		
		@PostMapping("customers/new")
		public ResponseEntity<CustomerMasterDTO> addCustomer(@RequestBody CustomerMasterDTO customerMasterDTO) {
			
			log.info("Adding a customer");
			CustomerMasterDTO addedCustomer = customerMasterService.addCustomer(customerMasterDTO);
			if(addedCustomer!= null) {
				return new ResponseEntity<>(HttpStatus.CREATED); 
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			
		}
		
		
		@GetMapping("customers")
		public ResponseEntity<List<CustomerMasterDTO>> getAllCustomers() {
			
			log.info("Getting all customers");
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
		
		
		@PutMapping("customers/{custId}/update")
		public ResponseEntity<CustomerMasterDTO> updateCustomer(@PathVariable String custId, @RequestBody CustomerMasterDTO customerDTO) {
			
			log.info("Update a customer based on customer id");
			customerDTO.setCustId(custId);
			CustomerMasterDTO updatedCustomer = customerMasterService.updateCustomer(custId, customerDTO);
			if(updatedCustomer !=null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		
		@GetMapping("customers/{custId}")
		public ResponseEntity<CustomerMasterDTO> getCustomerById(@PathVariable String custId){
			
			log.info("Get a customer based on customer id");
			CustomerMasterDTO customerDTO = customerMasterService.getCustomerById(custId);
			if(customerDTO != null) {
				return new ResponseEntity<CustomerMasterDTO>(customerDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
}

