package com.cognizant.banking.globalexceptionhandler;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
 
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {
		ResponseEntity<String> errorResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		return errorResponse;
	}
}