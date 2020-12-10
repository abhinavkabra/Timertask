package com.example.pno.service;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@Component
@Setter
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PnOTimerTask extends TimerTask {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private InternalCache internalCache;
	
	private String appId;
	
	private Timer time;
	
	@Override
	public void run() {

		ResponseEntity<String> divResponse = restTemplate.getForEntity("http://localhost:8081/"+appId, String.class);
		if (divResponse.getStatusCode().equals(HttpStatus.OK) /* || startTime.before(startTime+8minutes) */) {
			internalCache.add(appId, divResponse.getBody());
			
			// Cancel or Purge the timer thread
			time.cancel();
			time.purge();
		}
	}
	
}
