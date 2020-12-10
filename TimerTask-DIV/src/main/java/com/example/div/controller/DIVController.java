package com.example.div.controller;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DIVController {

	@GetMapping("/{appId}")
	public ResponseEntity<String> getStatus(@PathVariable String appId) {
		int nextInt = new Random().nextInt();
		System.err.println("Random int" + nextInt);
		if(nextInt % 2 ==0) {
			return ResponseEntity.ok("Successful");
		}
		else {
			return ResponseEntity.accepted().body("Accepted");
		}
	}
	
	@PostMapping("/")
	public void createWorkflow() {
		
	}
	
}
