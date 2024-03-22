package com.cognizant.banking.dto;

import java.util.Date;
import lombok.Data;

import com.cognizant.banking.entities.CustomerMaster;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationDTO {

	@NotNull
	private String loanAppId;
	
	@NotNull
	@Min(value=0)
	private Integer loanAmt;
	
	@NotNull
	@Min(value=0)
	private Integer noOfYears;
	
	@NotEmpty
	private String purpose;
	
	@NotEmpty
	private String appStatus;
	
	@NotEmpty
	private String typeOfLoan;
	
	private Date loanAppDate;
	
	private String Status;
	
	private CustomerMaster customerMaster;

}
