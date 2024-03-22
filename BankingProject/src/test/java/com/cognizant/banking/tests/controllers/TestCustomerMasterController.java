//package com.cognizant.banking.tests.controllers;
//
//public class TestCustomerMasterController {
//
//}
//
//
//
//package com.cognizant.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyDouble;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyObject;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
//import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.Path;
//import javax.validation.metadata.ConstraintDescriptor;
//
//import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.boot.context.properties.bind.BindResult;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.client.ExpectedCount;
//import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.validation.BeanPropertyBindingResult;
//import org.springframework.validation.Errors;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.support.GenericWebApplicationContext;
//
//import com.cognizant.controller.EmployeeController;
//import com.cognizant.dao.EmployeeDAO;
//import com.cognizant.dto.EmployeeDTO;
//import com.cognizant.dto.EmployeeResponse;
//import com.cognizant.dto.EmployeeResponse;
//import com.cognizant.main.EmployeeDbh2RestApplication;
//import com.cognizant.service.EmployeeService;
//import com.cognizant.validation.EmployeeIdValidator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jayway.jsonpath.JsonPath;
//
//
//@AutoConfigureMockMvc
//@WebMvcTest
//@ContextConfiguration(classes = EmployeeDbh2RestApplication.class)
//public class TestEmployeeController {
//	
//    private MockMvc mockMvc;
//	@Mock
//	private EmployeeService employeeService;
//	@InjectMocks
//	private EmployeeController employeeController;
//	@Mock
//	private RestTemplate restTemplate;
//	@Autowired
//	private LocalValidatorFactoryBean validator;
//	private MockRestServiceServer mockServer;
//	private RestTemplate template;
//	private ObjectMapper mapper=new ObjectMapper();
//	
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc=MockMvcBuilders.standaloneSetup(employeeController).build();
//		template=new RestTemplate();
//		mockServer=MockRestServiceServer.createServer(template);
//	}
//	@Test
//	public void handleGetAllEmployees_positiveReturnValue() {
//		try {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		EmployeeResponse employeeResponse=new EmployeeResponse();
//		employeeResponse.setEmpId(1001);
//		employeeResponse.setEmpName("Sabbir");
//		employeeResponse.setEmpSalary(45000);
//		employeeResponse.setEmpDesignation("Trainer");
//		mockListOfEmployeeResponse.add(employeeResponse);
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		
//		ResponseEntity<?> responseEntity=employeeController.handleGetAllEmployees();
//		List<EmployeeResponse> actual=(List<EmployeeResponse>)responseEntity.getBody();
//		assertTrue(actual.size()>0);
//		}catch(Exception e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void handleGetAllEmployees_NegativeReturnValue() {
//		try {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		
//		ResponseEntity<?> responseEntity=employeeController.handleGetAllEmployees();
//		assertNull(responseEntity.getBody());
//		}catch(Exception e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void handleGetAllEmployees_positiveStatusCode() {
//		try {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		EmployeeResponse employeeResponse=new EmployeeResponse();
//		employeeResponse.setEmpId(1001);
//		employeeResponse.setEmpName("Sabbir");
//		employeeResponse.setEmpSalary(45000);
//		employeeResponse.setEmpDesignation("Trainer");
//		mockListOfEmployeeResponse.add(employeeResponse);
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		
//		ResponseEntity<?> responseEntity=employeeController.handleGetAllEmployees();
//		assertEquals(200,responseEntity.getStatusCodeValue());
//		}catch(Exception e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void handleGetAllEmployees_negativeStatusCode() {
//		try {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		ResponseEntity<?> responseEntity=employeeController.handleGetAllEmployees();
//		assertEquals(400,responseEntity.getStatusCodeValue());
//		}catch(Exception e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void persistEmployeeWhenEmpNameIsValid() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		validator.validateProperty(employeeDTO, "empName")
//		.stream()
//		.forEach((constraintViolation)->assertNull(constraintViolation));
//	}
//	@Test
//	public void persistEmployeeWhenEmpNameIsNotValid() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		validator.validateProperty(employeeDTO, "empName")
//		.stream()
//		.forEach((constraintViolation)->assertNotNull(constraintViolation));
//	}
//	@Test
//	public void persistEmployeeWhenEmpNameIsNotValidMessage() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		validator.validateProperty(employeeDTO, "empName")
//		.stream()
//		.forEach((constraintViolation)->assertEquals("Employee Name cannot be blank",constraintViolation.getMessage()));
//	}
//	
//	public void persistEmployeeWhenEmpDesignationIsValid() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		validator.validateProperty(employeeDTO, "empDesignation")
//		.stream()
//		.forEach((constraintViolation)->assertNull(constraintViolation));
//	}
//	public void persistEmployeeWhenEmpDesignationIsNotValidLessThan3Characters() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Tr");
//		
//		validator.validateProperty(employeeDTO, "empDesignation")
//		.stream()
//		.forEach((constraintViolation)->assertNotNull(constraintViolation));
//	}
//	public void persistEmployeeWhenEmpDesignationIsNotValidGreaterThan10Characters() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Senior Software Engineer");
//		
//		validator.validateProperty(employeeDTO, "empDesignation")
//		.stream()
//		.forEach((constraintViolation)->assertNotNull(constraintViolation));
//	}
//	@Test
//	public void persistEmployeeWhenEmpDesignationIsNotValidMessage() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		validator.validateProperty(employeeDTO, "empDesignation")
//		.stream()
//		.forEach((constraintViolation)->assertEquals("Designation must have minimum 3 characters and maximum 10 characters",constraintViolation.getMessage()));
//	}
//	
//	@Test
//	public void persistEmployeeWhenEmpIdIsNotValid() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		LocalValidatorFactoryBean mockOfLocalValidatorFactoryBean=Mockito.mock(LocalValidatorFactoryBean.class);
//		Set<ConstraintViolation<EmployeeDTO>> setOfConstraintViolation=new HashSet<>();
//		setOfConstraintViolation.add(new ConstraintViolation<EmployeeDTO>() {
//
//			@Override
//			public String getMessage() {
//				// TODO Auto-generated method stub
//				return "Employee ID already exists";
//			}
//
//			@Override
//			public String getMessageTemplate() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public EmployeeDTO getRootBean() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Class<EmployeeDTO> getRootBeanClass() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object getLeafBean() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object[] getExecutableParameters() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object getExecutableReturnValue() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path getPropertyPath() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object getInvalidValue() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public ConstraintDescriptor<?> getConstraintDescriptor() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public <U> U unwrap(Class<U> type) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		});
//		when(mockOfLocalValidatorFactoryBean.validateProperty(employeeDTO, "empId")).thenReturn(setOfConstraintViolation);
//		mockOfLocalValidatorFactoryBean.validateProperty(employeeDTO, "empId")
//		.stream()
//		.forEach((constraintViolation)->assertNotNull(constraintViolation));
//	}
//	
//	@Test
//	public void persistEmployeeWhenEmpIdIsNotValidMessage() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		
//		LocalValidatorFactoryBean mockOfLocalValidatorFactoryBean=Mockito.mock(LocalValidatorFactoryBean.class);
//		Set<ConstraintViolation<EmployeeDTO>> setOfConstraintViolation=new HashSet<>();
//		setOfConstraintViolation.add(new ConstraintViolation<EmployeeDTO>() {
//
//			@Override
//			public String getMessage() {
//				// TODO Auto-generated method stub
//				return "Employee ID already exists";
//			}
//
//			@Override
//			public String getMessageTemplate() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public EmployeeDTO getRootBean() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Class<EmployeeDTO> getRootBeanClass() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object getLeafBean() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object[] getExecutableParameters() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object getExecutableReturnValue() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path getPropertyPath() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Object getInvalidValue() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public ConstraintDescriptor<?> getConstraintDescriptor() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public <U> U unwrap(Class<U> type) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		});
//		when(mockOfLocalValidatorFactoryBean.validateProperty(employeeDTO, "empId")).thenReturn(setOfConstraintViolation);
//		mockOfLocalValidatorFactoryBean.validateProperty(employeeDTO, "empId")
//		.stream()
//		.forEach((constraintViolation)->assertEquals("Employee ID already exists",constraintViolation.getMessage()));
//	}
//	@Test
//	public void persistEmployeePositiveReturnValue() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		when(employeeService.persistEmployeeRequest(employeeDTO)).thenReturn("success");
//		
//		ResponseEntity<?> responseEntity=employeeController.persistEmployee(employeeDTO);
//		assertEquals(201,responseEntity.getStatusCodeValue());
//	}
//	@Test
//	public void persistEmployeeNegativeReturnValue() {
//		EmployeeDTO employeeDTO=new EmployeeDTO();
//		employeeDTO.setEmpId(1001);
//		employeeDTO.setEmpName("Sabbir");
//		employeeDTO.setEmpSalary(34000);
//		employeeDTO.setEmpDesignation("Trainer");
//		when(employeeService.persistEmployeeRequest(employeeDTO)).thenReturn("fail");
//		
//		ResponseEntity<?> responseEntity=employeeController.persistEmployee(employeeDTO);
//		assertEquals(400,responseEntity.getStatusCodeValue());
//	}
//	@Test
//	public void urihandleGetAllEmployees_Positive() {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		EmployeeResponse employeeResponse=new EmployeeResponse();
//		employeeResponse.setEmpId(1001);
//		employeeResponse.setEmpName("Sabbir");
//		employeeResponse.setEmpSalary(45000);
//		employeeResponse.setEmpDesignation("Trainer");
//		mockListOfEmployeeResponse.add(employeeResponse);
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		
//		try {
//			MvcResult mvcResult=mockMvc
//			.perform(get("http://localhost:8082/api/employees"))
//			.andExpect(status().isOk())
//			.andReturn();
//		} catch (Exception e) {
//			assertTrue(false);
//		}
//	}
//	
//	@Test
//	public void urihandleGetAllEmployees_Negative() {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		EmployeeResponse employeeResponse=new EmployeeResponse();
//		employeeResponse.setEmpId(1001);
//		employeeResponse.setEmpName("Sabbir");
//		employeeResponse.setEmpSalary(45000);
//		employeeResponse.setEmpDesignation("Trainer");
//		mockListOfEmployeeResponse.add(employeeResponse);
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		
//		try {
//			MvcResult mvcResult=mockMvc
//			.perform(get("http://localhost:8082/api/employee"))
//			.andExpect(status().isNotFound())
//			.andReturn();
//		} catch (Exception e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void urihandleGetAllEmployees_JSONData() {
//		List<EmployeeResponse> mockListOfEmployeeResponse=new ArrayList<>();
//		EmployeeResponse employeeResponse=new EmployeeResponse();
//		employeeResponse.setEmpId(1001);
//		employeeResponse.setEmpName("Sabbir");
//		employeeResponse.setEmpSalary(45000);
//		employeeResponse.setEmpDesignation("Trainer");
//		mockListOfEmployeeResponse.add(employeeResponse);
//		when(employeeService.getEmployeeResponseModels()).thenReturn(mockListOfEmployeeResponse);
//		
//		try {
//			MvcResult mvcResult=mockMvc
//			.perform(get("http://localhost:8082/api/employees"))
//			.andExpect(status().isOk())
//			.andReturn();
//			
//			String jsonData=mvcResult.getResponse().getContentAsString();
//			String actual=JsonPath.parse(jsonData).read("$[0].empName");
//			assertEquals("Sabbir",actual);
//		} catch (Exception e) {
//			//e.printStackTrace();
//			assertTrue(false);
//		}
//	}
//}
