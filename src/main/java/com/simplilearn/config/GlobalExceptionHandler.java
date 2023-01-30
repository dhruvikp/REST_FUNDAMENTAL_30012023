package com.simplilearn.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ArithmeticException.class)
	public String arighmatic() {
		return "Arithmatic error occurred, Please contact administrator!";
	}

	@ExceptionHandler(value = Exception.class)
	public String exception() {
		return "Internal error occurred";
	}

}
