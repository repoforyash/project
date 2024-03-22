package com.cognizant.banking.tests.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.cognizant.banking.dto.LoanApplicationDTO;
import com.cognizant.banking.entities.LoanApplication;

import com.cognizant.banking.repositories.LoanApplicationRepository;

import com.cognizant.banking.service.LoanApplicationServiceImpl;
import com.cognizant.banking.utilities.LoanApplicationValidation;


public class TestLoanApplicationService {

	
	@Mock
	private LoanApplicationRepository loanApplicationRepository;
	
	@Mock
	private LoanApplicationValidation loanApplicationValidation;
	
	@InjectMocks
	private LoanApplicationServiceImpl loanApplicationServiceImpl;
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	
	@Test
	public void testGetNewLoanApplications_positiveWhenApplicationIsFound() {
		
		
		try {
			
//			Iterable<LoanApplication> iterableMock=Mockito.mock(Iterable.class);
//			when(loanApplicationRepository.findAll()).thenReturn(iterableMock);
//			Iterator<LoanApplication> iteratorMock=Mockito.mock(Iterator.class);
//			
//			when(iterableMock.iterator()).thenReturn(iteratorMock);
//			when(iteratorMock.hasNext()).thenReturn(true).thenReturn(false);
//			
//			LoanApplication loanApplicationMock=Mockito.mock(LoanApplication.class);
//			
//			when(iteratorMock.next()).thenReturn(loanApplicationMock);
//			
//			when(loanApplicationMock.getLoanAppId()).thenReturn("LA1001");
//			when(loanApplicationMock.getLoanAmt()).thenReturn(10000);
//			when(loanApplicationMock.getNoOfYears()).thenReturn(4);
//			when(loanApplicationMock.getPurpose()).thenReturn("Car Loan");
//			when(loanApplicationMock.getAppStatus()).thenReturn("NewLoan");
//			when(loanApplicationMock.getLoanAppDate()).thenReturn(new Date());
//			when(loanApplicationMock.getTypeOfLoan()).thenReturn("Car");
//			when(loanApplicationMock.getStatus()).thenReturn("Accepted");
			
			//LoanApplicationRepository loanApplicationRepository = mock(LoanApplicationRepository.class);
			// Mocking the repository to return a single loan application
	        LoanApplication loanApplicationMock = new LoanApplication();
	        loanApplicationMock.setLoanAppId("LA1001");
	        loanApplicationMock.setLoanAmt(10000);
	        loanApplicationMock.setNoOfYears(4);
	        loanApplicationMock.setPurpose("Car Loan");
	        loanApplicationMock.setAppStatus("NewLoan");
	        loanApplicationMock.setLoanAppDate(new Date());
	        loanApplicationMock.setTypeOfLoan("Car");
	        loanApplicationMock.setStatus("Accepted");


	        // Mocking the findAll method of the repository to return a list containing the loan application
	        when(loanApplicationRepository.findByAppStatus("NewLoan")).thenReturn(Arrays.asList(loanApplicationMock));

						
			//invoking the service method to get the new loan applications
			List<LoanApplicationDTO> loanDTOList= loanApplicationServiceImpl.getNewLoanApplications();
			
			assertNotNull(loanDTOList);
			assertTrue(loanDTOList.size() == 1);
			//System.out.println(loanDTOList.size());
			}catch(Exception e) {
					
				assertTrue(false);
		}
			
	}
	
	
	@Test
	public void testGetNewLoanApplications_positiveWhenMoreThanOneApplicationIsFound() {
		
		try {
			
			LoanApplication loanApplicationMock = new LoanApplication();
	        loanApplicationMock.setLoanAppId("LA1001");
	        loanApplicationMock.setLoanAmt(10000);
	        loanApplicationMock.setNoOfYears(4);
	        loanApplicationMock.setPurpose("Car Loan");
	        loanApplicationMock.setAppStatus("NewLoan");
	        loanApplicationMock.setLoanAppDate(new Date());
	        loanApplicationMock.setTypeOfLoan("Car");
	        loanApplicationMock.setStatus("Accepted");

	        LoanApplication loanApplicationMock2 = new LoanApplication();
	        loanApplicationMock2.setLoanAppId("LA1002");
	        loanApplicationMock2.setLoanAmt(10000);
	        loanApplicationMock2.setNoOfYears(4);
	        loanApplicationMock2.setPurpose("Car Loan");
	        loanApplicationMock2.setAppStatus("NewLoan");
	        loanApplicationMock2.setLoanAppDate(new Date());
	        loanApplicationMock2.setTypeOfLoan("Car");
	        loanApplicationMock2.setStatus("Accepted");
	        

	        // Mocking the findAll method of the repository to return a list containing the loan application
	        when(loanApplicationRepository.findByAppStatus("NewLoan")).thenReturn(Arrays.asList(loanApplicationMock, loanApplicationMock2));

						
			//invoking the service method to get the new loan applications
			List<LoanApplicationDTO> loanDTOList= loanApplicationServiceImpl.getNewLoanApplications();
			
			assertNotNull(loanDTOList);
			assertTrue(loanDTOList.size() > 1);
			//System.out.println(loanDTOList.size());
			
			}catch(Exception e) {
				assertTrue(false);
		}
		
		
	}
	
//	@Test
//	public void testAddLoanApplication_Positive() {
//		
//		try {
//			LoanApplication mockOfLoanApplication = Mockito.mock(LoanApplication.class);
//			LoanApplicationDTO loanApplicationDTO=new LoanApplicationDTO();
//			loanApplicationDTO.setLoanAppId("LA1001");
//			loanApplicationDTO.setLoanAmt(10000);
//			loanApplicationDTO.setNoOfYears(5);
//			loanApplicationDTO.setPurpose("Home Loan");
//			loanApplicationDTO.setAppStatus("Newloan");
//			loanApplicationDTO.setLoanAppDate(new Date());
//			loanApplicationDTO.setTypeOfLoan("Car");
//			loanApplicationDTO.setStatus("Accepted");
//			
//			when(loanApplicationRepository.save(Mockito.any())).thenReturn(mockOfLoanApplication);
//			LoanApplicationDTO actual=loanApplicationServiceImpl.addLoanApplication(loanApplicationDTO);
//			assertNotEquals(null,actual);
//			
//		}catch(Exception e) {
////			e.printStackTrace();
////			System.out.println(e);
//			assertTrue(false);
//		}
//		
//	}
	
//	@Test
//	public void testAddLoanApplication_Negative() {
//		
//		try {
//			LoanApplicationRepository loanApplicationRepository = mock(LoanApplicationRepository.class);
//			
//			LoanApplication mockOfLoanApplication = Mockito.mock(LoanApplication.class);
//			
//			
//			LoanApplicationDTO loanApplicationDTO=new LoanApplicationDTO();
//			loanApplicationDTO.setLoanAppId("LA1001");
//			loanApplicationDTO.setLoanAmt(10000);
//			loanApplicationDTO.setNoOfYears(5);
//			loanApplicationDTO.setPurpose("Home Loan");
//			loanApplicationDTO.setAppStatus("NewLoan");
//			loanApplicationDTO.setLoanAppDate(new Date());
//			loanApplicationDTO.setTypeOfLoan("Car");
//			loanApplicationDTO.setStatus("Rejected");
//			
//			when(loanApplicationRepository.save(Mockito.any())).thenReturn(mockOfLoanApplication);
//			
//			//LoanApplicationServiceImpl loanApplicationServiceImpl = new LoanApplicationServiceImpl(loanApplicationRepository);
//			
//			LoanApplicationDTO actual=loanApplicationServiceImpl.addLoanApplication(loanApplicationDTO);
//			assertNull(actual);
//			assertEquals("Rejected", actual.getStatus());
//			
//		}catch(Exception e) {
////			e.printStackTrace();
////			System.out.println(e);
//			assertTrue(true);
//		}
//		
//	}
	
	
	@Test
	public void testGetLoanApplicationById_Positive() {
		
		try {
			String loanAppId="LA1001";
			LoanApplication loanApplication = new LoanApplication();
			loanApplication.setLoanAppId("LA1001");
			loanApplication.setLoanAmt(10000);
			loanApplication.setNoOfYears(5);
			loanApplication.setPurpose("Home Loan");
			loanApplication.setAppStatus("NewLoan");
			loanApplication.setLoanAppDate(new Date());
			loanApplication.setTypeOfLoan("Car");
			loanApplication.setStatus("Rejected");
			
		
			Optional<LoanApplication> optionalOfLoanApplication=Optional.of(loanApplication);
			when(loanApplicationRepository.findById(loanAppId)).thenReturn(optionalOfLoanApplication);
			LoanApplicationDTO loanApplicationDTO = loanApplicationServiceImpl.getLoanApplicationById(loanAppId);
			assertTrue(loanApplicationDTO!=null);
			}catch(Exception e) {
				//e.printStackTrace();
				assertTrue(false);
			}
		
	}
	
	
	@Test
	public void testGetLoanApplicationById_Negative() {
		
		try {
			String testLoanAppId="LA1002";
			//LoanApplication loanApplication = new LoanApplication();
//			loanApplication.setLoanAppId("LA1001");
//			loanApplication.setLoanAmt(10000);
//			loanApplication.setNoOfYears(5);
//			loanApplication.setPurpose("Home Loan");
//			loanApplication.setAppStatus("NewLoan");
//			loanApplication.setLoanAppDate(new Date());
//			loanApplication.setTypeOfLoan("Car");
//			loanApplication.setStatus("Accepted");
			
			Optional<LoanApplication> optionalOfLoanApplication=Optional.ofNullable(null);
			
			when(loanApplicationRepository.findById(testLoanAppId)).thenReturn(optionalOfLoanApplication.empty());
			LoanApplicationDTO loanApplicationDTO = loanApplicationServiceImpl.getLoanApplicationById(testLoanAppId);
			assertNull(loanApplicationDTO);
			}catch(Exception e) {
//				e.printStackTrace();
//				System.out.println(e);
				assertTrue(false);
			}
		
		
	}
	
	
	
	@Test
	public void testUpdateLoanApplication_Positive() {
		
		try {
	        
			//String testLoanAppId = "LA1001";	        

	        // create a mock loan application entity
			LoanApplication loanApplication = new LoanApplication();
			loanApplication.setLoanAppId("LA1001");
			loanApplication.setLoanAmt(10000);
			loanApplication.setNoOfYears(5);
			loanApplication.setPurpose("Home Loan");
			loanApplication.setAppStatus("NewLoan");
			loanApplication.setLoanAppDate(new Date());
			loanApplication.setTypeOfLoan("Car");
			loanApplication.setStatus("Accepted");
			
			//entity to optional
			Optional<LoanApplication> optionalOfLoanApplication=Optional.of(loanApplication);
			when(loanApplicationRepository.findById("LA1001")).thenReturn(optionalOfLoanApplication);
			
	        //create a dto with updated data
			LoanApplicationDTO loanUpdatedDTO = new LoanApplicationDTO();
			loanUpdatedDTO.setLoanAppId("LA1001");
			loanUpdatedDTO.setLoanAmt(10000);
			loanUpdatedDTO.setNoOfYears(5);
			loanUpdatedDTO.setPurpose("Car Loan");
			loanUpdatedDTO.setAppStatus("NewLoan");
			loanUpdatedDTO.setLoanAppDate(new Date());
			loanApplication.setTypeOfLoan("Car");
			loanUpdatedDTO.setStatus("Accepted");
			
			//mapping dto to entity
			LoanApplication updatedLoanApplication = new ModelMapper().map(loanUpdatedDTO, LoanApplication.class);
			
			when(loanApplicationRepository.save(loanApplication)).thenReturn(updatedLoanApplication);
			LoanApplicationDTO actual = loanApplicationServiceImpl.updateLoanApplication(loanUpdatedDTO);
    		assertNotEquals(null, actual);
    		}catch(Exception e) {
    			assertTrue(false);
    		}
		
		
	}
	
	
	
	@Test
	public void testUpdateLoanApplication_Negative() {
		
		try {
	        
			//String testLoanAppId = "LA1001";	        

	        // Act
			LoanApplication loanApplication = new LoanApplication();
			loanApplication.setLoanAppId("LA1001");
			loanApplication.setLoanAmt(10000);
			loanApplication.setNoOfYears(5);
			loanApplication.setPurpose("Home Loan");
			loanApplication.setAppStatus("NewLoan");
			loanApplication.setLoanAppDate(new Date());
			loanApplication.setTypeOfLoan("Car");
			loanApplication.setStatus("Accepted");
			
			//entity to optional
			Optional<LoanApplication> optionalOfLoanApplication=Optional.of(loanApplication);
			when(loanApplicationRepository.findById("LA1001")).thenReturn(optionalOfLoanApplication);
			
	        
			LoanApplicationDTO loanUpdatedDTO = new LoanApplicationDTO();
			loanUpdatedDTO.setLoanAppId("LA1001");
			loanUpdatedDTO.setLoanAmt(10000);
			loanUpdatedDTO.setNoOfYears(5);
			loanUpdatedDTO.setPurpose("Home Loan");
			loanUpdatedDTO.setAppStatus("NewLoan");
			loanUpdatedDTO.setLoanAppDate(new Date());
			loanApplication.setTypeOfLoan("Car");
			loanUpdatedDTO.setStatus("Accepted");
			
			//mapping dto to entity
			LoanApplication updatedLoanApplication = new ModelMapper().map(loanUpdatedDTO, LoanApplication.class);
			
			when(loanApplicationRepository.save(loanApplication)).thenReturn(updatedLoanApplication);
			LoanApplicationDTO actual = loanApplicationServiceImpl.updateLoanApplication(loanUpdatedDTO);
    		assertNotNull(actual);
    		}catch(Exception e) {
//    			e.printStackTrace();
//    			System.out.println(e);
    			assertTrue(false);
    		}
		
		
	}
	
	
	
	

    
    @Test
    void testCheckCustomerAcceptanceStatus_WhenApplicationIsApproved() {
        // Arrange
        String loanAppId = "HL1001";
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setAppStatus("Approved");
        when(loanApplicationRepository.findById(loanAppId)).thenReturn(Optional.of(loanApplication));
        
        // Act
        LoanApplicationDTO result = loanApplicationServiceImpl.checkCustomerAcceptanceStatus(loanAppId, "accepted");
        
        // Assert
        //assertNotNull(result);
        assertEquals("accepted", result.getAppStatus());
    }

    
    @Test
    void testCheckCustomerAcceptanceStatus_WhenApplicationIsNotApproved() {
        // Arrange
        String loanAppId = "HL1001";
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setAppStatus("Pending");
        when(loanApplicationRepository.findById(loanAppId)).thenReturn(Optional.of(loanApplication));
        
        // Act 
        LoanApplicationDTO result = loanApplicationServiceImpl.checkCustomerAcceptanceStatus(loanAppId, "accepted");
        
        //Assert
        //assertNotNull(result);
        assertEquals("Pending", result.getAppStatus());
    }
    

	
}
