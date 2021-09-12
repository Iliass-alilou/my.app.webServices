package com.iliass.app.webServices.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.iliass.app.webServices.Responses.ErrorMessage;





@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = UserException.class)
	 ResponseEntity<Object> handlerUserException (UserException exception , WebRequest webRequest) {
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());
			return new ResponseEntity<>(
					//exception .getMessage() ,
					errorMessage,
					new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
	 }
	
	//for others Exceptions 
	@ExceptionHandler(value = Exception.class)
	 ResponseEntity<Object> handlerOthersException (Exception exception , WebRequest webRequest) {
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());
			return new ResponseEntity<>(
					//exception .getMessage() ,
					errorMessage,
					new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
	 }
}
