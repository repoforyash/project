package com.cognizant.banking.tests.services;

import static org.junit.Assert.assertNotNull;
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
import org.springframework.beans.BeanUtils;
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
			
			}catch(Exception e) {
				assertTrue(false);
		}
		
		
	}

	
	@Test
	public void testGetLoanApplicationById_Positive() {
		
		try {
			String loanAppId="LA001";
			LoanApplication loanApplication = new LoanApplication();
			loanApplication.setLoanAppId("LA001");
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
			assertNotNull(loanApplicationDTO);
			}catch(Exception e) {
				
				assertTrue(false);
			}
		
	}
	
	
	@Test
	public void testGetLoanApplicationById_Negative() {
		
		try {
			String testLoanAppId="LA1002";
			
			Optional<LoanApplication> optionalOfLoanApplication=Optional.ofNullable(null);
			
			when(loanApplicationRepository.findById(testLoanAppId)).thenReturn(optionalOfLoanApplication.empty());
			loanApplicationServiceImpl.getLoanApplicationById(testLoanAppId);
			assertTrue(false);
			}catch(Exception e) {
				assertTrue(true);
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
			
			LoanApplication updatedLoanApplication = new LoanApplication();
			BeanUtils.copyProperties(loanUpdatedDTO, updatedLoanApplication);
			
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
			
			LoanApplication updatedLoanApplication = new LoanApplication();
			BeanUtils.copyProperties(loanUpdatedDTO, updatedLoanApplication);
			
			when(loanApplicationRepository.save(loanApplication)).thenReturn(updatedLoanApplication);
			LoanApplicationDTO actual = loanApplicationServiceImpl.updateLoanApplication(loanUpdatedDTO);
    		assertNotNull(actual);
    		}catch(Exception e) {

    			assertTrue(false);
    		}
		
		
	}
	
}
