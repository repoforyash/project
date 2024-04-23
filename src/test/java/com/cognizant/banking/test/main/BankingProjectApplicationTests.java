package com.cognizant.banking.test.main;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.banking.BankingProjectApplication;
import com.cognizant.banking.controllers.CustomerMasterController;


	@SpringBootTest(classes = BankingProjectApplication.class)
	public class BankingProjectApplicationTests {

		@Autowired
		private CustomerMasterController customerMasterController;
		
		@Test
		public void contextLoads() {
			assertNotNull(customerMasterController);
		}

	}
	

