package com.cognizant.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column; 
import java.util.Date;
import jakarta.persistence.Entity; 
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id; 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Loan_App_Detail_Master")
public class LoanAppDetailMaster {
	
	@Id
	@Column(name="Id")
	private Integer id1;

	@Column(name="Month_No")
	private Integer monthNo;
	
	@Column(name="Installment")
	private Integer installment;
	
	@Column(name="Interest_Rate")
	private Integer interestRate;
	
	@Column(name= "P_Out_Standing_Begin_Of_Mon")
	private Integer pOutStandingBeginOfMon;	
	
	@Column(name= "P_Repayment")
	private Integer pRepayment;
	
	@Column(name= "Pr_Out_Standing_End_Of_Mon")
	private Integer prOutStandingEndOfMon;
	
	@Column(name= "Last_Date_Of_Install_Pay")
	@Temporal(TemporalType.DATE)
	private Date lastDateOfInstallPay;
	
	@ManyToOne
	@JoinColumn(name="Loan_App_Id", referencedColumnName = "Loan_App_Id")
	private LoanApplication loanApplication;
	

}
