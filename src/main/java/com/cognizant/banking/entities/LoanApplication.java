package com.cognizant.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Loan_Application")
public class LoanApplication {
	
	@Id
	@Column(name="Loan_App_Id")
	private String loanAppId;
	
	@Column(name="Loan_Amt")
	private Integer loanAmt;
	
	@Column(name="No_Of_Years")
	private Integer noOfYears;
	
	@Column(name="Purpose")
	private String purpose;
		
	@Column(name="App_Status")
	private String appStatus;
	
	@Column(name= "Type_Of_Loan")
	private String typeOfLoan;
	
	@Column(name="Loan_App_Date")
	@Temporal(TemporalType.DATE)
	private Date loanAppDate;
	
	@Column(name="Status")
	private String status;
	
	@ManyToOne
	@JoinColumn (name= "Cust_Id", referencedColumnName = "Cust_Id")
	private CustomerMaster customerMaster;

}
