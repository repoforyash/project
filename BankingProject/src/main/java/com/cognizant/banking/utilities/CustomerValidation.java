package com.cognizant.banking.utilities;

import java.time.LocalDate;
import java.util.Optional;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.banking.dto.CustomerMasterDTO;
import com.cognizant.banking.entities.CustomerMaster;
import com.cognizant.banking.repositories.CustomerMasterRepository;
import com.cognizant.banking.exceptions.AgeBarException;
import com.cognizant.banking.exceptions.DuplicateAccountException;


@Component
public class CustomerValidation {
	
	@Autowired
	private CustomerMasterRepository customerRepository;
	

	public CustomerValidation(CustomerMasterRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	
	public void validateCustomer(CustomerMasterDTO customerDTO){
		
		if((Integer.toString(customerDTO.getContactNo())).length() != 10) {
			throw new IllegalArgumentException("Phone number should be exactly 10 digits long");
		}
		
		if(!customerDTO.getEmailId().endsWith("@cognizant.com")) {
			throw new IllegalArgumentException("Email address should end with @cognizant.com");
		}
		
		if(!customerDTO.getCustFirstName().matches("[a-zA-Z]+") || !customerDTO.getCustLastName().matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("First Name and Last Name should only have alphabets");
		}
		
		if(!(customerDTO.getCustLastName().length() >= 3)) {
			throw new IllegalArgumentException("Last Name must be minimun 3 characters long");
		}
		
		Optional<CustomerMaster> CustomerOptional = customerRepository.findByAdharCard(customerDTO.getAdharCard());
		CustomerMaster existingCustomer=CustomerOptional.orElse(null);
		if(existingCustomer != null) {
			throw new DuplicateAccountException("Adhar Card already exists in the system");
		}
		
		LocalDate dob = customerDTO.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int age = Period.between(dob, LocalDate.now()).getYears();
		if(age < 18 || age > 58) {
			throw new AgeBarException("Customer age must be between 18 and 58 years");
		}
		if(customerDTO.getMonthlySalary() <= 0) {
			throw new IllegalArgumentException("Salary must be greater than 0");
		}
		
	}
	
}
	

