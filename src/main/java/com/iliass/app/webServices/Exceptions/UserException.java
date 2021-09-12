package com.iliass.app.webServices.Exceptions;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = -4123382910157013144L;

	public UserException(String message){
		// supper : to initialize our constructor 
		super(message);
	}
}
