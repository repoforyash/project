package com.cognizant.banking.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMasterDTO {
	
	@NotEmpty
	@Size(min=6, max=6)
	private String custId;
	
	@NotEmpty
	@Size(min=3)
	private String custFirstName;
	
	@NotEmpty
	@Size(min=3)
	private String custLastName;

	private String address;

	private String city;

	private String state;
	
	private long contactNo;

	private int adharCard;
	
	private String emailId;
	
	private Date birthDate;

	private int monthlySalary;

}
