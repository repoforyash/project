package com.cognizant.banking.tests.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cognizant.banking.entities.LoanAppDetailMaster;
import com.cognizant.banking.entities.LoanApplication;
import com.cognizant.banking.repositories.LoanAppDetailMasterRepository;


@DataJpaTest
class LoanAppDetailMasterTest {
	@Autowired
	private LoanAppDetailMasterRepository repository;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void testFindAllPositive() {
		LoanAppDetailMaster l = new LoanAppDetailMaster();
		
		l.setId1(1001);
		l.setMonthNo(9);
		l.setInstallment(5);
		l.setInterestRate(10);
		l.setPOutStandingBeginOfMon(7000);
		l.setPRepayment(2000);
		l.setPrOutStandingEndOfMon(5000);
		l.setLastDateOfInstallPay(new Date(2002-03-03));
		
		LoanApplication l2 = new LoanApplication();
		
		l2.setLoanAppId("1001");
		l2.setLoanAmt(5000);
		l2.setNoOfYears(10);
		l2.setPurpose("Car");
		l2.setAppStatus("Approved");
		l2.setTypeOfLoan("CarLoan");
		l2.setLoanAppDate(new Date(2001-03-03));
		l2.setStatus("Accepted");
		
	
		entityManager.persist(l2);
		LoanApplication la=entityManager.find(LoanApplication.class, "1001");
		
		l.setLoanApplication(la);
		
		entityManager.persist(l);
		Iterable<LoanAppDetailMaster> it = repository.findAll();
		assertTrue(it.iterator().hasNext());
	}
	@Test
	public void testFindAllNegative() {
		Iterable<LoanAppDetailMaster> it = repository.findAll();
		assertTrue(!it.iterator().hasNext());
	}
	
	
	@Test
	public void testFindByIdPositive() {
		LoanAppDetailMaster l = new LoanAppDetailMaster();

		l.setId1(1001);
		l.setMonthNo(9);
		l.setInstallment(5);
		l.setInterestRate(10);
		l.setPOutStandingBeginOfMon(7000);
		l.setPRepayment(2000);
		l.setPrOutStandingEndOfMon(5000);
		l.setLastDateOfInstallPay(new Date(2002-03-03));
		
		LoanApplication l2 = new LoanApplication();
		
		l2.setLoanAppId("1001");
		l2.setLoanAmt(5000);
		l2.setNoOfYears(10);
		l2.setPurpose("Car");
		l2.setAppStatus("Approved");
		l2.setTypeOfLoan("CarLoan");
		l2.setLoanAppDate(new Date(2001-03-03));
		l2.setStatus("Accepted");
		
	
		entityManager.persist(l2);
		LoanApplication la=entityManager.find(LoanApplication.class, "1001");
		
		l.setLoanApplication(la);
		
		entityManager.persist(l);
		Optional<LoanAppDetailMaster> loan = repository.findById("1001");
		assertTrue(loan.isPresent());
	}
	
	@Test
	public void testFindByIdNegative() {
		Optional<LoanAppDetailMaster> loan = repository.findById("1001");
		assertTrue(!loan.isPresent());
	}
	
	@Test
	public void testSavePositive() {
		LoanAppDetailMaster l = new LoanAppDetailMaster();

		l.setId1(1001);
		l.setMonthNo(9);
		l.setInstallment(5);
		l.setInterestRate(10);
		l.setPOutStandingBeginOfMon(7000);
		l.setPRepayment(2000);
		l.setPrOutStandingEndOfMon(5000);
		l.setLastDateOfInstallPay(new Date(2002-03-03));
		
		LoanApplication l2 = new LoanApplication();
		
		l2.setLoanAppId("1001");
		l2.setLoanAmt(5000);
		l2.setNoOfYears(10);
		l2.setPurpose("Car");
		l2.setAppStatus("Approved");
		l2.setTypeOfLoan("CarLoan");
		l2.setLoanAppDate(new Date(2001-03-03));
		l2.setStatus("Accepted");
		
	
		entityManager.persist(l2);
		LoanApplication la=entityManager.find(LoanApplication.class, "1001");
		
		l.setLoanApplication(la);
		
		repository.save(l);
		Optional<LoanAppDetailMaster> loan = repository.findById("1001");
		assertTrue(loan.isPresent());
	}
	
	@Test
	public void testDeletePositive() {
		LoanAppDetailMaster l = new LoanAppDetailMaster();

		l.setId1(1001);
		l.setMonthNo(9);
		l.setInstallment(5);
		l.setInterestRate(10);
		l.setPOutStandingBeginOfMon(7000);
		l.setPRepayment(2000);
		l.setPrOutStandingEndOfMon(5000);
		l.setLastDateOfInstallPay(new Date(2002-03-03));
		
		LoanApplication l2 = new LoanApplication();
		
		l2.setLoanAppId("1001");
		l2.setLoanAmt(5000);
		l2.setNoOfYears(10);
		l2.setPurpose("Car");
		l2.setAppStatus("Approved");
		l2.setTypeOfLoan("CarLoan");
		l2.setLoanAppDate(new Date(2001-03-03));
		l2.setStatus("Accepted");
		
	
		entityManager.persist(l2);
		LoanApplication la=entityManager.find(LoanApplication.class, "1001");
		
		l.setLoanApplication(la);
		
		repository.delete(l);
		Optional<LoanAppDetailMaster> loan = repository.findById("1001");
		assertTrue(!loan.isPresent());
	}

}
