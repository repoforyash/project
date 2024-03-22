package com.cognizant.banking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReducedPaymentDTO {
	
	@NotNull
	private String loanAppId;
	
	@NotNull
	private Integer pOutStandingBeginOfMon;
		
	
	@NotNull
	private Integer  prOutStandingEndOfMon;
	
	
}
