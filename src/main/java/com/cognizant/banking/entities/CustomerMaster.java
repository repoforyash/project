package com.cognizant.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import java.util.Date;
import jakarta.persistence.Column;  
import jakarta.persistence.Id; 
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email; 


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customer_Master")
public class CustomerMaster {
	
	@Id
	@Column(name="Cust_Id", length=6)
	private String custId;
	
	@Column(name="Cust_First_Name")
	private String custFirstName;
	
	@Column(name="Cust_Last_Name")
	private String custLastName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Contact_No")
	private long contactNo;
	
	@Column(name="Adhar_Card")
	private int adharCard;
	
	@Column(name="Email_Id")
	@Email
	private String emailId;
	
	@Column(name="Birth_Date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name="Monthly_Salary")
	private int monthlySalary;

}
