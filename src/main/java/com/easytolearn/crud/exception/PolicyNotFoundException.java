package com.easytolearn.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class PolicyNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public PolicyNotFoundException(String message) {
		super(message);
	}
	
	public PolicyNotFoundException(String message, Throwable t) {
		super(message, t);
	}

}
