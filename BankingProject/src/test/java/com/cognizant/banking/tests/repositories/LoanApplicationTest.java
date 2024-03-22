package com.cognizant.banking.tests.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.banking.BankingProjectApplication;
import com.cognizant.banking.entities.CustomerMaster;
import com.cognizant.banking.entities.LoanApplication;
import com.cognizant.banking.repositories.LoanApplicationRepository;


@DataJpaTest
@ContextConfiguration(classes = BankingProjectApplication.class)
class  LoanApplicationTest {
	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testFindAllPositive() {
		
		
		LoanApplication l = new LoanApplication();
		
		l.setLoanAppId("1001");
		l.setLoanAmt(5000);
		l.setNoOfYears(10);
		l.setPurpose("Car");
		l.setAppStatus("NewLoan");
		l.setTypeOfLoan("CarLoan");
		l.setLoanAppDate(new Date(2000-01-01));
		l.setStatus("Accepted");
		
		CustomerMaster c = new CustomerMaster();
		
		c.setCustId("1001");
		c.setCustFirstName("TestName");
		c.setCustLastName("One");
		c.setAddress("Cognizant CDC");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(12345);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		entityManager.persist(c);
		CustomerMaster ca = entityManager.find(CustomerMaster.class, "1001");
		
		l.setCustomerMaster(ca);
		
		
		

		entityManager.persist(l);
		Iterable<LoanApplication> loan = loanApplicationRepository.findAll();
		assertTrue(loan.iterator().hasNext());
	}
	@Test
	public void testFindAllNegative() {
		Iterable<LoanApplication> loan = loanApplicationRepository.findAll();
		assertTrue(!loan.iterator().hasNext());
	}
	
	
	@Test
	public void testFindByIdPositive() {
		LoanApplication l = new LoanApplication();
		
		l.setLoanAppId("1001");
		l.setLoanAmt(5000);
		l.setNoOfYears(10);
		l.setPurpose("Car");
		l.setAppStatus("NewLoan");
		l.setTypeOfLoan("CarLoan");
		l.setLoanAppDate(new Date(2000-01-01));
		l.setStatus("Accepted");
		
		CustomerMaster c = new CustomerMaster();
		
		c.setCustId("1001");
		c.setCustFirstName("TestName");
		c.setCustLastName("One");
		c.setAddress("Cognizant CDC");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(12345);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		entityManager.persist(c);
		CustomerMaster ca = entityManager.find(CustomerMaster.class,"1001");
		
		l.setCustomerMaster(ca);
		
		entityManager.persist(l);
		Optional<LoanApplication> loan = loanApplicationRepository.findById("1001");
		assertTrue(loan.isPresent());
	}
	
	@Test
	public void testFindByIdNegative() {
		Optional<LoanApplication> loan = loanApplicationRepository.findById("1001");
		assertTrue(!loan.isPresent());
	}
	
	@Test
	public void testSavePositive() {
		LoanApplication l = new LoanApplication();
		
		l.setLoanAppId("1001");
		l.setLoanAmt(5000);
		l.setNoOfYears(10);
		l.setPurpose("Car");
		l.setAppStatus("NewLoan");
		l.setTypeOfLoan("CarLoan");
		l.setLoanAppDate(new Date(2000-01-01));
		l.setStatus("Accepted");
		
		CustomerMaster c = new CustomerMaster();
		
		c.setCustId("100");
		c.setCustFirstName("TestName");
		c.setCustLastName("One");
		c.setAddress("Cognizant CDC");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(12345);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		entityManager.persist(c);
		CustomerMaster ca = entityManager.find(CustomerMaster.class,"1001");
		
		l.setCustomerMaster(ca);
		
		loanApplicationRepository.save(l);
		Optional<LoanApplication> loan = loanApplicationRepository.findById("1001");
		assertTrue(loan.isPresent());
	}
	
	@Test
	public void testDeletePositive() {
		LoanApplication l = new LoanApplication();
		
		l.setLoanAppId("1001");
		l.setLoanAmt(5000);
		l.setNoOfYears(10);
		l.setPurpose("Car");
		l.setAppStatus("NewLoan");
		l.setTypeOfLoan("CarLoan");
		l.setLoanAppDate(new Date(2000-01-01));
		l.setStatus("Accepted");
		
		CustomerMaster c = new CustomerMaster();

		c.setCustId("1001");
		c.setCustFirstName("TestName");
		c.setCustLastName("One");
		c.setAddress("Cognizant CDC");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(12345);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		entityManager.persist(c);
		CustomerMaster ca = entityManager.find(CustomerMaster.class,"1001");
		
		l.setCustomerMaster(ca);
		
		loanApplicationRepository.delete(l);
		Optional<LoanApplication> loan = loanApplicationRepository.findById("1001");
		assertTrue(!loan.isPresent());
	}

}
