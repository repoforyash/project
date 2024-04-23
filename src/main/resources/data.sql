INSERT INTO Users VALUES('yash','yash123','admin',false);
INSERT INTO Users VALUES('amit','amit123','user',false);

INSERT INTO Customer_Master(Cust_Id, Cust_First_Name, Cust_Last_Name, Address, City, State, Contact_No, Adhar_Card, Email_Id, Birth_Date, Monthly_Salary)
VALUES ('CUS001', 'Yash', 'Biswakarma', 'Cognizant', 'Pune', 'Maharashtra', '1234567890', '00001111', 'sample1@cognizant.com', '2000-02-12', '40000'),
	   ('CUS002', 'Raj', 'Singh', 'Cognizant', 'Mumbai', 'Maharashtra', '1234567890', '00002222', 'sample2@cognizant.com', '2000-02-12', '40000');
	   
	   
INSERT INTO Loan_Application(Loan_App_Id, Cust_Id, Loan_Amt, No_Of_Years, Purpose, App_Status, Type_Of_Loan, Loan_App_Date, Status)
VALUES ('LA001', 'CUS001', 10000, 5, 'Home Loan', 'NewLoan', 'Home', '2001-02-02', 'Accepted'),
	   ('LA002', 'CUS002', 20000, 6, 'Car Loan', 'NewLoan', 'Car', '2001-02-01', 'Accepted'),
	   ('LA003', 'CUS002', 30000, 7, 'Land Loan', 'Approved', 'Land', '2001-02-01', 'NoStatus');
	   
	   
INSERT INTO Loan_App_Detail_Master(Id, Loan_App_Id, Month_No, Installment, Interest_Rate, P_Out_Standing_Begin_Of_Mon, P_Repayment, Pr_Out_Standing_End_Of_Mon, Last_Date_Of_Install_Pay)
VALUES (1, 'LA001', 5, 1, 12,  15000, 5000, 10000, '2000-02-02'),
	   (2, 'LA001', 5, 1, 12,  12000, 2000, 10000, '2000-02-02'),
	   (3, 'LA001', 5, 1, 12,  10000, 1000, 9000, '2000-02-02'),
	   (4, 'LA002', 6, 2, 12,  15000, 5000, 10000, '2000-03-03');
	   