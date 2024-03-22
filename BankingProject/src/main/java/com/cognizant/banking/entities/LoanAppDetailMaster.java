package com.cognizant.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column; 
import java.util.Date;
import jakarta.persistence.Entity; 
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id; 
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

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
	@NotNull
	@Min(value=0)
	private Integer monthNo;
	
	@Column(name="Installment")
	@NotNull
	@Min(value=0)
	private Integer installment;
	
	@Column(name="Interest_Rate")
	@NotNull
	@Min(value=0)
	private Integer interestRate;
	
	@Column(name= "P_OutStandingBeginOfMon")
	private Integer pOutStandingBeginOfMon;
		
	
	@Column(name= "P_Repayment")
	private Integer pRepayment;
	
	@Column(name= "Pr_OutStandingEndOfMon")
	private Integer prOutStandingEndOfMon;
	
	@Column(name= "Last_Date_Of_Install_Pay")
	@NotNull
	private Date lastDateOfInstallPay;
	
	@OneToOne
	@JoinColumn(name="Loan_App_Id", referencedColumnName = "Loan_App_Id")
	private LoanApplication loanApplication;

	
//	public Integer getId() {
//		return id1;
//	}
//
//	public void setId(Integer id1) {
//		this.id1 = id1;
//	}
	
//	public Integer getLoanAppId() {
//		return loanAppId;
//	}
//
//	public void setLoanAppId(Integer loanAppId) {
//		this.loanAppId = loanAppId;
//	}

//	public Integer getMonthNo() {
//		return monthNo;
//	}
//
//	public void setMonthNo(Integer monthNo) {
//		this.monthNo = monthNo;
//	}
//
//	public Integer getInstallment() {
//		return installment;
//	}
//
//	public void setInstallment(Integer installment) {
//		this.installment = installment;
//	}
//
//	public Integer getInterestRate() {
//		return interestRate;
//	}
//
//	public void setInterestRate(Integer interestRate) {
//		this.interestRate = interestRate;
//	}
//
//	public Integer getOnOutstandingBeginOfMo() {
//		return onOutstandingBeginOfMo;
//	}
//
//	public void setOnOutstandingBeginOfMo(Integer onOutstandingBeginOfMo) {
//		this.onOutstandingBeginOfMo = onOutstandingBeginOfMo;
//	}
//
//	public Integer getpRepayment() {
//		return pRepayment;
//	}
//
//	public void setpRepayment(Integer pRepayment) {
//		this.pRepayment = pRepayment;
//	}
//
//	public Integer getPrOutstandingEndOfMon() {
//		return prOutstandingEndOfMon;
//	}
//
//	public void setPrOutstandingEndOfMon(Integer prOutstandingEndOfMon) {
//		this.prOutstandingEndOfMon = prOutstandingEndOfMon;
//	}
//
//	public Date getLastDateOfInstallPay() {
//		return lastDateOfInstallPay;
//	}
//
//	public void setLastDateOfInstallPay(Date lastDateOfInstallPay) {
//		this.lastDateOfInstallPay = lastDateOfInstallPay;
//	}
//
//	public LoanApplication getLoanApplication() {
//		return loanApplication;
//	}
//
//	public void setLoanApplication(LoanApplication loanApplication) {
//		this.loanApplication = loanApplication;
//	}
	
	
	

}
