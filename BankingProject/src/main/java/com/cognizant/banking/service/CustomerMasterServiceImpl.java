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
	
//	private
//	CustomerValidation customerValidation=new CustomerValidation(customerRepository);
	
	//@Autowired
/*	public CustomerMasterServiceImpl(CustomerValidation customerValidation, CustomerMasterRepository customerRepository) {
		this.customerRepository = customerRepository;
		this.customerValidation = customerValidation;
		
	} */
	

	//get all customers
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
	public CustomerMasterDTO addCustomer(CustomerMasterDTO customerDTO) {
		CustomerValidation customerValidation=new CustomerValidation(customerRepository);
		customerValidation.validateCustomer(customerDTO); //validate the customer
		String customerID = GenerateCustomerID.generateID(customerDTO.getCustLastName()); //generate ID
		customerDTO.setCustId(customerID); //setting the generated ID
		
		//BEAN UTILS
		CustomerMaster customer = new CustomerMaster();
		
			BeanUtils.copyProperties(customerDTO, customer);
			CustomerMaster savedCustomer = customerRepository.save(customer);
			CustomerMasterDTO savedCustomerDTO = new CustomerMasterDTO();
			BeanUtils.copyProperties(savedCustomer, savedCustomerDTO);
		
			return savedCustomerDTO;
	}
	

	



	
	@Override
	public CustomerMasterDTO updateCustomer(String custId, CustomerMasterDTO customerDTO){
		CustomerValidation customerValidation=new CustomerValidation(customerRepository);
		customerValidation.validateCustomer(customerDTO);
		
		java.util.Optional<CustomerMaster> optionalCustomer = customerRepository.findById(custId);
		if(optionalCustomer.isPresent()) {
			CustomerMaster existingCustomer = optionalCustomer.get();
			
				//validate the new customer data
				//new CustomerUtils().validateCustomer(customerDTO);
	
				//copy from dto to existing customer
				BeanUtils.copyProperties(customerDTO, existingCustomer);
				//save the updated customer
				CustomerMaster updatedCustomer = customerRepository.save(existingCustomer);
				//convert updated customer to dto
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
		
		// Retrieve customer entity from repository
        CustomerMaster customer = customerRepository.findById(custId).orElse(null);

        // Check if customer entity exists
        if (customer != null) {
            // Create a new CustomerDTO object
            CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();

            // Copy properties from customer entity to customer DTO using BeanUtils
            BeanUtils.copyProperties(customer, customerMasterDTO);

            // Return the populated CustomerDTO
            return customerMasterDTO;
        } else {
            // If customer entity not found, return null
            return null;
        }
    }

		
}

	

