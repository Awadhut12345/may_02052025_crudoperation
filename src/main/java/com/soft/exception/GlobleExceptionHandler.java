package com.soft.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.soft.DTO.ErrorResponse;

@ControllerAdvice
public class GlobleExceptionHandler {
		
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now()			
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Intrnal Server Error",
				LocalDateTime.now()	
		);		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
