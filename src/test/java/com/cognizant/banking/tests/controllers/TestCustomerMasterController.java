package com.cognizant.banking.tests.controllers;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolation;

import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.cognizant.banking.controllers.CustomerMasterController;
import com.cognizant.banking.repositories.CustomerMasterRepository;
import com.cognizant.banking.dto.CustomerMasterDTO;

import com.cognizant.banking.BankingProjectApplication;
import com.cognizant.banking.service.CustomerMasterService;
import com.cognizant.banking.utilities.CustomerValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(classes = BankingProjectApplication.class)
public class TestCustomerMasterController {

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
	
	
	
	
	@Test
	public void getAllCustomers_positiveAssertReturnValue() {
		
		List<CustomerMasterDTO> customerMasterDTOList = new ArrayList<>();
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		customerMasterDTO.setCustId("CUS001");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		customerMasterDTOList.add(customerMasterDTO);
		
		try {
		
		when(customerMasterService.getAllCustomers()).thenReturn(customerMasterDTOList);
		ResponseEntity<?> responseEntity = customerMasterController.getAllCustomers();
		List<CustomerMasterDTO> actual=(List<CustomerMasterDTO>)responseEntity.getBody();
		assertTrue(actual.size()>0);
		
		}catch(Exception e) {
			assertTrue(false);
		}
	
	}
	
	
	@Test
	public void getAllCustomers_positiveAssertStatusCode() {
		
		List<CustomerMasterDTO> customerMasterDTOList = new ArrayList<>();
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		customerMasterDTO.setCustId("CUS001");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		customerMasterDTOList.add(customerMasterDTO);
		
		try {
		
		when(customerMasterService.getAllCustomers()).thenReturn(customerMasterDTOList);
		ResponseEntity<?> responseEntity = customerMasterController.getAllCustomers();
		assertEquals(200,responseEntity.getStatusCodeValue());
		
		}catch(Exception e) {
			assertTrue(false);
		}
	
	}
	
	@Test
	public void getAllCustomers_negativeAssertReturnValue() {
		
		List<CustomerMasterDTO> customerMasterDTOList = new ArrayList<>();
		
		try {
		
		when(customerMasterService.getAllCustomers()).thenReturn(customerMasterDTOList);
		ResponseEntity<?> responseEntity = customerMasterController.getAllCustomers();
		List<CustomerMasterDTO> actual=(List<CustomerMasterDTO>)responseEntity.getBody();
		assertNull(responseEntity.getBody());
		
		}catch(Exception e) {
			assertTrue(false);
		}
	
	}
	
	@Test
	public void getAllCustomers_negativeAssertStatusCode() {
		
		List<CustomerMasterDTO> customerMasterDTOList = new ArrayList<>();
	
		try {
		
		when(customerMasterService.getAllCustomers()).thenReturn(customerMasterDTOList);
		ResponseEntity<?> responseEntity = customerMasterController.getAllCustomers();
		assertEquals(400,responseEntity.getStatusCodeValue());
		
		}catch(Exception e) {
			assertTrue(false);
		}
	
	}
	
	@Test
	public void addCustomer_WhenCustIdIsValid() {
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		
		customerMasterDTO.setCustId("CUS001");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		validator.validateProperty(customerMasterDTO, "custId")
		.stream()
		.forEach((constraintViolation)->assertNull(constraintViolation));
		
	}
	
	
	@Test
	public void addCustomer_WhenCustIdIsNotValid() {
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		
		customerMasterDTO.setCustId("c1");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		validator.validateProperty(customerMasterDTO, "custId")
		.stream()
		.forEach((constraintViolation)->assertNotNull(constraintViolation));
		
	}
	
	
	@Test
	public void addCustomer_WhenCustFirstNameIsValid() {
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		
		customerMasterDTO.setCustId("CU001");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		validator.validateProperty(customerMasterDTO, "custFirstName")
		.stream()
		.forEach((constraintViolation)->assertNull(constraintViolation));
		
	}
	
	
	@Test
	public void addCustomer_WhenCustLastNameIsValid() {
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		
		customerMasterDTO.setCustId("CU001");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		validator.validateProperty(customerMasterDTO, "custLastName")
		.stream()
		.forEach((constraintViolation)->assertNull(constraintViolation));
		
	}
	
	
	@Test
	public void addCustomer_WhenCustFirstNameIsNotValidLessThan3Characters() {
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		
		customerMasterDTO.setCustId("CU001");
		customerMasterDTO.setCustFirstName("Me");
		customerMasterDTO.setCustLastName("Biswakarma");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		validator.validateProperty(customerMasterDTO, "custFirstName")
		.stream()
		.forEach((constraintViolation)->assertNotNull(constraintViolation));
		
	}
	
	@Test
	public void addCustomer_WhenCustLastNameIsNotValidLessThan3Characters() {
		
		CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
		
		customerMasterDTO.setCustId("CU001");
		customerMasterDTO.setCustFirstName("Yash");
		customerMasterDTO.setCustLastName("Bk");
		customerMasterDTO.setAddress("Cognizant");
		customerMasterDTO.setCity("Pune");
		customerMasterDTO.setState("Maharashtra");
		customerMasterDTO.setContactNo(1234567890L);
		customerMasterDTO.setAdharCard(123456789);
		customerMasterDTO.setEmailId("yash.biswakarma@cognizant.com");
		customerMasterDTO.setBirthDate(new Date(2001-02-02));
		customerMasterDTO.setMonthlySalary(300000);
		
		validator.validateProperty(customerMasterDTO, "custLastName")
		.stream()
		.forEach((constraintViolation)->assertNotNull(constraintViolation));
		
	}
		
}
