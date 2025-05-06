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
		ErrorResponse error = new ErrorResponse(404,"Employee Not Present in Database",LocalDateTime.now());
		ResponseEntity<ErrorResponse> response= new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return response;
	}
	
	
	
}
