package com.cognizant.banking.dto;

import java.util.Date;
import lombok.Data;

import com.cognizant.banking.entities.CustomerMaster;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "NewLoan|Canceled|Approved|Sanctioned", message="Allowed values are NewLoan, Cancelled, Approved, or Sannctioned")
	private String appStatus;
	
	@NotEmpty
	private String typeOfLoan;
	
	private Date loanAppDate;
	
	@Pattern(regexp = "Accepted|Rejected|No Status", message="Allowed values are Accepted, Rejected or No Status")
	private String Status;
	
	//private CustomerMaster customerMaster;
	
	private String custId;

}
