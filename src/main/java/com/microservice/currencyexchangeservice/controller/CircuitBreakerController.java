package com.microservice.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/test-circuit")
	@Retry(name = "", fallbackMethod = "hardcodedResponse")
	public String sample() {
		logger.info("Sample API called");
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-yo", String.class);
		return forEntity.getBody();
//		return "hello";
	}
	
	public String hardcodedResponse() {
		return "hard-coded response";
	}
	
}
