drop table if exists Customer_Master;
drop table if exists Loan_Application;
drop table if exists Loan_App_Detail_Master;


CREATE TABLE Users(
	user_name varchar(40),
	password varchar(40) not null,
	role varchar(40) not null,
	is_Account_Locked boolean
);


CREATE TABLE Customer_Master(
	Cust_Id VARCHAR(20) PRIMARY KEY,
	Cust_First_Name VARCHAR(20),
	Cust_Last_Name VARCHAR(20),
	Address VARCHAR(20),
	City VARCHAR(20),
	State VARCHAR(20),
	Contact_No LONG,
	Adhar_Card INT,
	Email_Id VARCHAR(30),
	Birth_Date DATE,
	Monthly_Salary INT
);
	
	
CREATE TABLE Loan_Application(
	Loan_App_Id VARCHAR(20) PRIMARY KEY,
	Cust_Id VARCHAR(20),
	Loan_Amt INT,
	No_Of_Years INT,
	Purpose VARCHAR(20),
	App_Status varchar(20),
	Type_Of_Loan VARCHAR(20),
	Loan_App_Date DATE,
	Status varchar(20),
	CONSTRAINT FK_Loan_Appilication_Customer FOREIGN KEY (Cust_Id) REFERENCES Customer_Master(Cust_Id)
);
	
	
	
		
CREATE TABLE Loan_App_Detail_Master(
	Id INT PRIMARY KEY,
	Loan_App_Id VARCHAR(20),
	Month_No INT,
	Installment INT,
	Interest_Rate INT,
	P_Out_Standing_Begin_Of_Mon INT,
	P_Repayment INT,
	Pr_Out_Standing_End_Of_Mon INT,
	Last_Date_Of_Install_Pay DATE,
	CONSTRAINT FK_Loan_App_Detail_Master_Loan_Application FOREIGN KEY (Loan_App_Id) REFERENCES Loan_Application(Loan_App_Id)
);


