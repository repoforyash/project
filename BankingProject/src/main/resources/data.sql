INSERT INTO Customer_Master(Cust_Id, Cust_First_Name, Cust_Last_Name, Address, City, State, Contact_No, Adhar_Card, Email_Id, Birth_Date, Monthly_Salary)
VALUES ('CUS001', 'Yash', 'Biswakarma', 'Cognizant', 'Pune', 'Maharashtra', '1234567890', '123456789', 'yashdbs001@cognizant.com', '2000-02-12', '40000'),
	   ('CUS002', 'Raj', 'Singh', 'Cognizant', 'Pune', 'Maharashtra', '1234567890', '123456789', 'yashdbs001@cognizant.com', '2000-02-12', '40000');
	   
	   
INSERT INTO Loan_Application(Loan_App_Id, Cust_Id, Loan_Amt, No_Of_Years, Purpose, App_Status, Type_Of_Loan, Loan_App_Date, Status)
VALUES ('LA001', 'CUS001', 10000, 5, 'Home Loan', 'NewLoan', 'Car', '2001-02-02', 'Accepted'),
	   ('LA002', 'CUS002', 10000, 5, 'Car Loan', 'NewLoan', 'Car', '2001-02-01', 'Accepted');
	   
	   
INSERT INTO Loan_App_Detail_Master(Id, Loan_App_Id, Month_No, Installment, Interest_Rate, P_OutStandingBeginOfMon, P_Repayment, Pr_OutStandingEndOfMon, Last_Date_Of_Install_Pay)
VALUES (1, 'LA001', 5, 1, 12,  15000, 5000, 10000, '2000-02-02'),
	   (2, 'LA001', 5, 1, 12,  12000, 2000, 10000, '2000-02-02'),
	   (3, 'LA001', 5, 1, 12,  10000, 1000, 9000, '2000-02-02'),
	   (4, 'LA002', 6, 2, 12,  15000, 5000, 10000, '2000-03-03');
	   