package com.cognizant.banking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.banking.dto.CustomerMasterDTO;
import com.cognizant.banking.entities.CustomerMaster;
import com.cognizant.banking.repositories.CustomerMasterRepository;
import com.cognizant.banking.utilities.CustomerValidation;
import com.cognizant.banking.utilities.GenerateCustomerID;

@Service
public class CustomerMasterServiceImpl implements CustomerMasterService {

	@Autowired
	private CustomerMasterRepository customerRepository;
	

	@Override
	public CustomerMasterDTO addCustomer(CustomerMasterDTO customerDTO) {
		
		CustomerValidation customerValidation=new CustomerValidation(customerRepository);
		customerValidation.validateCustomer(customerDTO); 
		String customerID = GenerateCustomerID.generateID(customerDTO.getCustLastName()); //generate ID
		customerDTO.setCustId(customerID); 
		
		CustomerMaster customer = new CustomerMaster();
		
			BeanUtils.copyProperties(customerDTO, customer);
			CustomerMaster savedCustomer = customerRepository.save(customer);
			CustomerMasterDTO savedCustomerDTO = new CustomerMasterDTO();
			BeanUtils.copyProperties(savedCustomer, savedCustomerDTO);
		
			return savedCustomerDTO;
	}
	

	@Override
	public List<CustomerMasterDTO> getAllCustomers() {
		
		Iterable<CustomerMaster> customers = customerRepository.findAll();
		List<CustomerMasterDTO> customerDTOs = new ArrayList<>();

		for(CustomerMaster customer : customers) {
			CustomerMasterDTO customerDTO = new CustomerMasterDTO();

				BeanUtils.copyProperties(customer,customerDTO );
				customerDTOs.add(customerDTO);
					
		}
		return customerDTOs;
	}

	
	@Override
	public CustomerMasterDTO updateCustomer(String custId, CustomerMasterDTO customerDTO){
		
		CustomerValidation customerValidation=new CustomerValidation(customerRepository);
		customerValidation.validateCustomer(customerDTO);
		
		java.util.Optional<CustomerMaster> optionalCustomer = customerRepository.findById(custId);
		if(optionalCustomer.isPresent()) {
			CustomerMaster existingCustomer = optionalCustomer.get();
				
				BeanUtils.copyProperties(customerDTO, existingCustomer);			
				CustomerMaster updatedCustomer = customerRepository.save(existingCustomer);				
				CustomerMasterDTO updatedCustomerDTO = new CustomerMasterDTO();
				BeanUtils.copyProperties(updatedCustomer, updatedCustomerDTO);
				return updatedCustomerDTO;
						
		}
		else {
			throw new RuntimeException("Customer not found with id: " + custId);
		}
		
	}



	@Override
	public CustomerMasterDTO getCustomerById(String custId) {
		
        CustomerMaster customer = customerRepository.findById(custId).orElse(null);
     
        if (customer != null) {
           
            CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();        
            BeanUtils.copyProperties(customer, customerMasterDTO);          
            return customerMasterDTO;
            
        } else {        
            return null;
        }
    }

		
}

	

