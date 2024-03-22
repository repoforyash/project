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
import jakarta.validation.constraints.Min; 
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;







import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Loan_Application")
public class LoanApplication {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Loan_App_Id")
	private String loanAppId;
	
	@Column(name="Loan_Amt")
	@NotNull
	@Min(value=0)
	private Integer loanAmt;
	
	@Column(name="No_Of_Years")
	@NotNull
	@Min(value=0)
	private Integer noOfYears;
	
	@Column(name="Purpose")
	@NotEmpty
	private String purpose;
	
	
	@Column(name="App_Status")
	@NotEmpty
	private String appStatus;
	
	@Column(name= "Type_Of_Loan")
	@NotEmpty
	private String typeOfLoan;
	
	@Column(name="Loan_App_Date")
	private Date loanAppDate;
	
	@Column(name="Status")
	private String Status;
	
	@ManyToOne
	@JoinColumn (name= "Cust_Id", referencedColumnName = "Cust_Id")
	private CustomerMaster customerMaster;

	
	
	
	
	

//	public String getLoanAppId() {
//		return loanAppId;
//	}
//
//	public void setLoanAppId(String loanAppId) {
//		this.loanAppId = loanAppId;
//	}
	

//	public Integer getLoanAmt() {
//		return loanAmt;
//	}
//
//	public void setLoanAmt(Integer loanAmt) {
//		this.loanAmt = loanAmt;
//	}
//
//	public Integer getNoOfYears() {
//		return noOfYears;
//	}
//
//	public void setNoOfYears(Integer noOfYears) {
//		this.noOfYears = noOfYears;
//	}
//
//	public String getPurpose() {
//		return purpose;
//	}
//
//	public void setPurpose(String purpose) {
//		this.purpose = purpose;
//	}
//
//	public String getAppStatus() {
//		return appStatus;
//	}
//
//	public void setAppStatus(String appStatus) {
//		this.appStatus = appStatus;
//	}
//
//	public String getTypeOfLoan() {
//		return typeOfLoan;
//	}
//
//	public void setTypeOfLoan(String typeOfLoan) {
//		this.typeOfLoan = typeOfLoan;
//	}
//
//	public Date getLoanAppDate() {
//		return loanAppDate;
//	}
//
//	public void setLoanAppDate(Date date) {
//		this.loanAppDate = date;
//	}
//	
//	public void setStatus(String Status) {
//		this.Status = Status;
//	}
//	
//	public String getStatus() {
//		return Status;
//	}
//
//	public CustomerMaster getCustomerMaster() {
//		return customerMaster;
//	}
//
//	public void setCustomerMaster(CustomerMaster customerMaster) {
//		this.customerMaster = customerMaster;
//	}
}
