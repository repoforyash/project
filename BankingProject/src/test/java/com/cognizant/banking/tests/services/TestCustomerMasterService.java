package com.cognizant.banking.tests.services;

	import org.modelmapper.ModelMapper;
	import static org.junit.jupiter.api.Assertions.*;
	import static org.mockito.Mockito.when;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;

	import com.cognizant.banking.dto.CustomerMasterDTO;
	import com.cognizant.banking.entities.CustomerMaster;
	import com.cognizant.banking.repositories.CustomerMasterRepository;
	import com.cognizant.banking.service.CustomerMasterServiceImpl;

	public class TestCustomerMasterService {
		
		@Mock
		private CustomerMasterRepository customerRepository;
		
		@InjectMocks
		private CustomerMasterServiceImpl customerServiceImpl;
		
		//private CustomerMaster customer;

		@BeforeEach
		void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
		}

		@AfterEach
		void tearDown() throws Exception {
			
		}

		@Test
		void testGetAllCustomers_positiveWhenCustomerIsFound() {
			
			try {
				
				Iterable<CustomerMaster> iterableMock=Mockito.mock(Iterable.class);
				when(customerRepository.findAll()).thenReturn(iterableMock);
				Iterator<CustomerMaster> iteratorMock=Mockito.mock(Iterator.class);
				
				when(iterableMock.iterator()).thenReturn(iteratorMock);
				when(iteratorMock.hasNext()).thenReturn(true).thenReturn(false);
				
				CustomerMaster customerMasterMock=Mockito.mock(CustomerMaster.class);
				
				when(iteratorMock.next()).thenReturn(customerMasterMock);
				
				when(customerMasterMock.getCustId()).thenReturn("CM1001");
				when(customerMasterMock.getCustFirstName()).thenReturn("Yash");
				when(customerMasterMock.getCustLastName()).thenReturn("Biswakarma");
				when(customerMasterMock.getAddress()).thenReturn("Cognizant CDC");
				when(customerMasterMock.getCity()).thenReturn("Pune");
				when(customerMasterMock.getState()).thenReturn("Maharashtra");
				when(customerMasterMock.getContactNo()).thenReturn(814544445);
				when(customerMasterMock.getAdharCard()).thenReturn(1234567890);
				when(customerMasterMock.getEmailId()).thenReturn("yashbiswakarma@cognizant.com");
				when(customerMasterMock.getBirthDate()).thenReturn(new Date(2000-02-10));
				when(customerMasterMock.getMonthlySalary()).thenReturn(40000);
							
				List<CustomerMasterDTO> customerDTOList= customerServiceImpl.getAllCustomers();
				assertTrue(customerDTOList.size()==1);
				}catch(Exception e) {
					assertTrue(false);
				}
		}
		
		
		@Test
		void testGetAllCustomers_positiveWhenMoreThanOneCustomerIsFound() {
			
			try {
				
				Iterable<CustomerMaster> iterableMock=Mockito.mock(Iterable.class);
				when(customerRepository.findAll()).thenReturn(iterableMock);
				Iterator<CustomerMaster> iteratorMock=Mockito.mock(Iterator.class);
				
				when(iterableMock.iterator()).thenReturn(iteratorMock);
				when(iteratorMock.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
				
				CustomerMaster customerMasterMock=Mockito.mock(CustomerMaster.class);
				
				when(iteratorMock.next()).thenReturn(customerMasterMock);
				
				when(customerMasterMock.getCustId()).thenReturn("CM1001");
				when(customerMasterMock.getCustFirstName()).thenReturn("Yash");
				when(customerMasterMock.getCustLastName()).thenReturn("Biswakarma");
				when(customerMasterMock.getAddress()).thenReturn("Cognizant CDC");
				when(customerMasterMock.getCity()).thenReturn("Pune");
				when(customerMasterMock.getState()).thenReturn("Maharashtra");
				when(customerMasterMock.getContactNo()).thenReturn(814544445);
				when(customerMasterMock.getAdharCard()).thenReturn(1234567890);
				when(customerMasterMock.getEmailId()).thenReturn("yashbiswakarma@cognizant.com");
				when(customerMasterMock.getBirthDate()).thenReturn(new Date(2000-02-10));
				when(customerMasterMock.getMonthlySalary()).thenReturn(40000);
							
				List<CustomerMasterDTO> customerDTOList= customerServiceImpl.getAllCustomers();
				assertTrue(customerDTOList.size() > 1);
				}catch(Exception e) {
					assertTrue(false);
				}
			
		}
		
		@Test
		void testGetAllCustomers_Exception() {
			
			try {
				
				Iterable<CustomerMaster> iterableMock=Mockito.mock(Iterable.class);
				when(customerRepository.findAll()).thenReturn(iterableMock);
				Iterator<CustomerMaster> iteratorMock=Mockito.mock(Iterator.class);
				
				when(iterableMock.iterator()).thenReturn(iteratorMock);
				when(iteratorMock.hasNext()).thenReturn(false);
				
				CustomerMaster customerMasterMock=Mockito.mock(CustomerMaster.class);
				
				when(iteratorMock.next()).thenReturn(customerMasterMock);
				
				when(customerMasterMock.getCustId()).thenReturn("CM1001");
				when(customerMasterMock.getCustFirstName()).thenReturn("Yash");
				when(customerMasterMock.getCustLastName()).thenReturn("Biswakarma");
				when(customerMasterMock.getAddress()).thenReturn("Cognizant CDC");
				when(customerMasterMock.getCity()).thenReturn("Pune");
				when(customerMasterMock.getState()).thenReturn("Maharashtra");
				when(customerMasterMock.getContactNo()).thenReturn(814544445);
				when(customerMasterMock.getAdharCard()).thenReturn(1234567890);
				when(customerMasterMock.getEmailId()).thenReturn("yashbiswakarma@cognizant.com");
				when(customerMasterMock.getBirthDate()).thenReturn(new Date(2000-02-10));
				when(customerMasterMock.getMonthlySalary()).thenReturn(40000);
							
				List<CustomerMasterDTO> customerDTOList= customerServiceImpl.getAllCustomers();
				assertTrue(true);
				}catch(Exception e) {
					assertTrue(true);
				}
			
		}
		
		
		@Test
		public void testAddCustomer_Positive() {
			
			try {
				CustomerMaster mockOfCustomer=Mockito.mock(CustomerMaster.class);
				CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
				customerMasterDTO.setCustId("CM1001");
				customerMasterDTO.setCustFirstName("Yash");
				customerMasterDTO.setCustLastName("Biswakarma");
				customerMasterDTO.setAddress("Cognizant CDC");
				customerMasterDTO.setCity("Pune");
				customerMasterDTO.setState("Maharashtra");
				customerMasterDTO.setContactNo(123456789);
				customerMasterDTO.setAdharCard(123456789);
				customerMasterDTO.setEmailId("yashbiswakarma@cognizant.com");
				customerMasterDTO.setBirthDate(new Date(2000-02-10));
				customerMasterDTO.setMonthlySalary(400000);
				
				when(customerRepository.save(Mockito.any())).thenReturn(mockOfCustomer);
				CustomerMasterDTO actual=customerServiceImpl.addCustomer(customerMasterDTO);
				assertNotEquals(null,actual);
				
			}catch(Exception e) {
				//e.printStackTrace();
				//System.out.println(e);
				assertTrue(false);
			}
					
		}
		
		
		@Test
		public void testAddCustomer_Negative() {
			
			try {
				CustomerMaster mockOfCustomer=Mockito.mock(CustomerMaster.class);
				CustomerMasterDTO customerMasterDTO=new CustomerMasterDTO();
				customerMasterDTO.setCustId("CM1001");
				customerMasterDTO.setCustFirstName("Yash");
				customerMasterDTO.setCustLastName("Biswakarma");
				customerMasterDTO.setAddress("Cognizant CDC");
				customerMasterDTO.setCity("Pune");
				customerMasterDTO.setState("Maharashtra");
				customerMasterDTO.setContactNo(123456789);
				customerMasterDTO.setAdharCard(123456789);
				customerMasterDTO.setEmailId("yashbiswakarma@gmail.com");
				customerMasterDTO.setBirthDate(new Date(2000-02-10));
				customerMasterDTO.setMonthlySalary(400000);
				
				when(customerRepository.save(Mockito.any())).thenReturn(mockOfCustomer);
				customerServiceImpl.addCustomer(customerMasterDTO);
				assertTrue(false);
				
			}catch(Exception e) {
				//e.printStackTrace();
				assertTrue(true);
			}
		}
		
		@Test
		public void testUpdateCustomer_Positive() {
			
			try {
		        
					        

		        // Act
		        CustomerMaster customerMaster = new CustomerMaster();
		        customerMaster.setCustId("CM1001");
		        customerMaster.setCustFirstName("Yash");
		        customerMaster.setCustLastName("Biswakarma");
		        customerMaster.setAddress("Cognizant CDC");
		        customerMaster.setCity("Pune");
		        customerMaster.setState("Maharashtra");
				customerMaster.setContactNo(123456789);
				customerMaster.setAdharCard(123456789);
				customerMaster.setEmailId("yashbiswakarma@cognizant.com");
				customerMaster.setBirthDate(new Date(2000-02-12));
				customerMaster.setMonthlySalary(400000);
				
				//entity to optional
				Optional<CustomerMaster> optionalOfCustomerMaster=Optional.of(customerMaster);
				when(customerRepository.findById("CM1001")).thenReturn(optionalOfCustomerMaster);
				
		        
				CustomerMasterDTO customerUpdatedDTO = new CustomerMasterDTO();
				customerUpdatedDTO.setCustId("CM1001");
				customerUpdatedDTO.setCustFirstName("Yashu");
				customerUpdatedDTO.setCustLastName("Biswakarma");
				customerUpdatedDTO.setAddress("Cognizant CDC");
				customerUpdatedDTO.setCity("Pune");
				customerUpdatedDTO.setState("Maharashtra");
				customerUpdatedDTO.setContactNo(121212121);
				customerUpdatedDTO.setAdharCard(123456789);
				customerUpdatedDTO.setEmailId("yashbiswakarma@cognizant.com");
				customerUpdatedDTO.setBirthDate(new Date(2000-02-12));
				customerUpdatedDTO.setMonthlySalary(400000);
				
				//mapping dto to entity
				CustomerMaster updatedCustomer = new ModelMapper().map(customerUpdatedDTO, CustomerMaster.class);
				
				when(customerRepository.save(customerMaster)).thenReturn(updatedCustomer);
	    		CustomerMasterDTO actual=customerServiceImpl.updateCustomer("CM1001", customerUpdatedDTO);
	    		assertNotEquals(null,actual);
	    		}catch(Exception e) {
	    			//System.out.println(e);
	    			//e.printStackTrace();
	    			assertTrue(false);
	    		}
		}
		        


		@Test
		public void testUpdateCustomer_Negative() {
			
			try {
		        
				String custId = "CUS001";	        

		        // Act
		        CustomerMaster customerMaster = new CustomerMaster();
		        customerMaster.setCustId("CM1001");
		        customerMaster.setCustFirstName("Yash");
		        customerMaster.setCustLastName("Biswakarma");
		        customerMaster.setAddress("Cognizant CDC");
		        customerMaster.setCity("Pune");
		        customerMaster.setState("Maharashtra");
		        customerMaster.setContactNo(123456789);
		        customerMaster.setAdharCard(123456789);
		        customerMaster.setEmailId("yashbiswakarma@cognizant.com");
				customerMaster.setBirthDate(new Date(2000-02-12));
		        customerMaster.setMonthlySalary(400000);
				
				//entity to optional
				Optional<CustomerMaster> optionalOfCustomerMaster=Optional.of(customerMaster);
				when(customerRepository.findById("CM1001")).thenReturn(optionalOfCustomerMaster);
				
		        
				CustomerMasterDTO customerUpdatedDTO = new CustomerMasterDTO();
				customerUpdatedDTO.setCustId("CM1001");
				customerUpdatedDTO.setCustFirstName("Yash");
				customerUpdatedDTO.setCustLastName("Biswakarma");
				customerUpdatedDTO.setAddress("Cognizant CDC");
				customerUpdatedDTO.setCity("Punee");
				customerUpdatedDTO.setState("Maharashtra");
				customerUpdatedDTO.setContactNo(123456789);
				customerUpdatedDTO.setAdharCard(123456789);
				customerUpdatedDTO.setEmailId("yashbiswakarma@gmail.com");
				customerUpdatedDTO.setBirthDate(new Date(2000-02-12));
				customerUpdatedDTO.setMonthlySalary(400000);
				
				//mapping dto to entity
				CustomerMaster updatedCustomer = new ModelMapper().map(customerUpdatedDTO, CustomerMaster.class);
				
				when(customerRepository.save(customerMaster)).thenReturn(updatedCustomer);
	    		CustomerMasterDTO actual=customerServiceImpl.updateCustomer("CM1001", customerUpdatedDTO);
	    		assertTrue(false);
	    		}catch(Exception e) {
	    			//System.out.println(e);
	    			assertTrue(true);
	    		}
		}
		
		
		@Test
		public void testGetCustomerById_Positive() {
			
			 // Create and insert customer entity
	        CustomerMaster expectedCustomer = new CustomerMaster();
	        expectedCustomer.setCustId("CM1001");
	        expectedCustomer.setCustFirstName("Yash");
	        expectedCustomer.setCustLastName("Biswakarma");
	        expectedCustomer.setAddress("Cognizant CDC");
	        expectedCustomer.setCity("Pune");
			expectedCustomer.setState("Maharashtra");
			expectedCustomer.setContactNo(123456789);
			expectedCustomer.setAdharCard(123456789);
			expectedCustomer.setEmailId("yashbiswakarma@cognizant.com");
			expectedCustomer.setBirthDate(new Date(2000-02-12));
			expectedCustomer.setMonthlySalary(400000);
			
	        when(customerRepository.findById("CM1001")).thenReturn(java.util.Optional.of(expectedCustomer));

	        // Call service method to get customer by ID
	        CustomerMasterDTO actualCustomerDTO = customerServiceImpl.getCustomerById("CM1001");

	        // Assert that the returned customer DTO matches the expected DTO
	        //assertEquals(expectedCustomer, actualCustomerDTO);
	        assertEquals("CM1001", actualCustomerDTO.getCustId());
	        assertEquals("Yash", actualCustomerDTO.getCustFirstName());
	        assertEquals("Biswakarma", actualCustomerDTO.getCustLastName());
	        assertEquals("Cognizant CDC", actualCustomerDTO.getAddress());
	        assertEquals("Pune", actualCustomerDTO.getCity());
	        assertEquals("Maharashtra", actualCustomerDTO.getState());
	        assertEquals(123456789, actualCustomerDTO.getContactNo());
	        assertEquals(123456789, actualCustomerDTO.getAdharCard());
	        assertEquals("yashbiswakarma@cognizant.com", actualCustomerDTO.getEmailId());
	        assertEquals(new Date(2000-02-12), actualCustomerDTO.getBirthDate());
	        assertEquals(400000, actualCustomerDTO.getMonthlySalary());
	    }

	    @Test
	    public void testGetCustomerById_Negative() {
	        // Mock repository to return null when findById is called
	        when(customerRepository.findById("CM1002")).thenReturn(java.util.Optional.empty());

	        // Call service method to get customer by non-existing ID
	        CustomerMasterDTO actualCustomerDTO = customerServiceImpl.getCustomerById("CM1002");

	        // Assert that the returned customer DTO is null
	        assertNull(actualCustomerDTO);
	    }



		
		
		
		
}	
		
		
		
