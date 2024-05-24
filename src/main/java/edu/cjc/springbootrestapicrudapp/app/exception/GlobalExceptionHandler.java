package edu.cjc.springbootrestapicrudapp.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<APIError> productNotFoundExceptionHandler(ProductNotFoundException e,HttpServletRequest request)
	
	{
//		System.out.println("Exception Handled succcessfully");
//		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		
		
		System.out.println("Handled");
		APIError error=new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpMessage(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}

}
