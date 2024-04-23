package com.cognizant.banking.service;

import java.util.List;

import com.cognizant.banking.dto.CustomerMasterDTO;


public interface CustomerMasterService{
	

	public List<CustomerMasterDTO> getAllCustomers();

	public CustomerMasterDTO addCustomer(CustomerMasterDTO customer);

	public CustomerMasterDTO getCustomerById(String customerId);
	
	public CustomerMasterDTO updateCustomer(String customerId, CustomerMasterDTO customer);	

}
