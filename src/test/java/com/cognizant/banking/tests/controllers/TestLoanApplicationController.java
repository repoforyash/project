package com.cognizant.banking.tests.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

import com.cognizant.banking.BankingProjectApplication;
import com.cognizant.banking.controllers.CustomerMasterController;
import com.cognizant.banking.service.CustomerMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = BankingProjectApplication.class)
public class TestLoanApplicationController {

	private MockMvc mockMvc;
	@Mock
	private CustomerMasterService customerMasterService;
	@InjectMocks
	private CustomerMasterController customerMasterController;
	@Mock
	private RestTemplate restTemplate;
	
	@Autowired
	private LocalValidatorFactoryBean validator;
	private MockRestServiceServer mockServer;
	private RestTemplate template;
	private ObjectMapper mapper=new ObjectMapper();
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(customerMasterController).build();
		template=new RestTemplate();
		mockServer=MockRestServiceServer.createServer(template);
	}
	
	
	
	
}
