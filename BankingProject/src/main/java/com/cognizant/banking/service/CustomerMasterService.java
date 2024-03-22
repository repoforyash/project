package com.cognizant.banking.service;

import java.util.List;

import com.cognizant.banking.dto.CustomerMasterDTO;


public interface CustomerMasterService{
	
	

	
	//return list of customers
	public List<CustomerMasterDTO> getAllCustomers();

	//add new customer	
	public CustomerMasterDTO addCustomer(CustomerMasterDTO customer);
	
	//get specific customer information
	public CustomerMasterDTO getCustomerById(String customerId);
	
	//update existing customer	
	public CustomerMasterDTO updateCustomer(String customerId, CustomerMasterDTO customer);

	
	

}
