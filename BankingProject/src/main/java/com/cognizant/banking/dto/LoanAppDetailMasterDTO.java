package com.cognizant.banking.dto;

import java.util.Date;

import com.cognizant.banking.entities.LoanApplication;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanAppDetailMasterDTO {
		
		private Integer id1;	
		
//		@NotNull
//		private String loanAppId;
		
		@NotNull
		@Min(value=0)
		private Integer monthNo;
		
		@NotNull
		@Min(value=0)
		private Integer installment;
		
		@NotNull
		@Min(value=0)
		private Integer interestRate;
		
		@NotNull
		private Integer pOutStandingBeginOfMon;
			
		@NotNull
		private Integer pRepayment;
		
		@NotNull
		private Integer prOutStandingEndOfMon;
		
		@NotNull
		private Date lastDateOfInstallPay;
		
		private LoanApplication loanApplication;


	}

