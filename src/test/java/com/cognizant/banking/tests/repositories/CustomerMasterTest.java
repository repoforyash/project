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
import com.cognizant.banking.repositories.CustomerMasterRepository;


@DataJpaTest
@ContextConfiguration(classes = BankingProjectApplication.class)
public class CustomerMasterTest {
	
	@Autowired
	private CustomerMasterRepository repository;
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void testSavePositive() {
		CustomerMaster c = new CustomerMaster();
		c.setCustId("CU1001");
		c.setCustFirstName("TestName");
		c.setCustLastName("Three");
		c.setAddress("Synechron");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(1234567890L);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma3@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		repository.save(c);
		entityManager.flush();
		
		Optional<CustomerMaster> customer = repository.findById("CU1001");
		assertTrue(customer.isPresent());
	}
	
	
	@Test
	public void testSaveNegative() {
		Optional<CustomerMaster> customer = repository.findById("CU1001");
		assertTrue(!customer.isPresent());
	}
	
	
	@Test
	public void testFindAllPositive() {
		CustomerMaster c = new CustomerMaster();
		c.setCustId("CU1000");
		c.setCustFirstName("TestName");
		c.setCustLastName("One");
		c.setAddress("Cognizant CDC");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(1234567890L);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		entityManager.persist(c);
		entityManager.flush();
		
		Iterable<CustomerMaster> it = repository.findAll();
		assertTrue(it.iterator().hasNext());
	}
	@Test
	public void testFindAllNegative() {
		Iterable<CustomerMaster> it = repository.findAll();
		assertTrue(!it.iterator().hasNext());
	}
	
	
	@Test
	public void testFindByIdPositive() {
		CustomerMaster c = new CustomerMaster();
		c.setCustId("CU1001");
		c.setCustFirstName("TestName");
		c.setCustLastName("Two");
		c.setAddress("Capgemini");
		c.setCity("Pune");
		c.setState("Maharashtra");
		c.setContactNo(1234567890L);
		c.setAdharCard(67890);
		c.setEmailId("yash.biswakarma2@cognizant.com");
		c.setBirthDate(new Date(2002-02-02));
		c.setMonthlySalary(300000);
		
		entityManager.persist(c);
		entityManager.flush();
		
		Optional<CustomerMaster> customer = repository.findById("CU1001");
		assertTrue(customer.isPresent());
	}
	
	@Test
	public void testFindByIdNegative() {
		Optional<CustomerMaster> customer = repository.findById("CU1001");
		assertTrue(!customer.isPresent());
	}
	

}
