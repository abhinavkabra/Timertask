package com.example.pno.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.pno.model.InitiateDIV;
import com.example.pno.service.InternalCache;
import com.example.pno.service.PnOService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PnOController {
	
	private PnOService pnoService;
	
	private InternalCache internalCache;

	@PostMapping("/")
	public ResponseEntity<?> post(@RequestBody InitiateDIV initiateDIV) {
		return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pnoService.initiateFlow(initiateDIV))
                .toUri()).build();
		
	}
	
	@GetMapping("/{appId}")
	public String getStatus(@PathVariable String appId) {
		return internalCache.get(appId);
	}
	
}
