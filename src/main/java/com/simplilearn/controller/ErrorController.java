package com.simplilearn.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	@GetMapping("/calculate1")
	public int calculate() {
		int a = 5;
		int b = 0;
		
		int res = a / b;

		return res;
	}
}
