package com.example.pno.service;

import java.util.Date;
import java.util.Timer;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.example.pno.model.InitiateDIV;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PnOService {
	
    private WebApplicationContext context;

	public String initiateFlow(InitiateDIV initiateDIV) {
		
		String appId = UUID.randomUUID().toString();
		Timer time = new Timer();
		PnOTimerTask pnoTimerTask = context.getBean(PnOTimerTask.class);
		pnoTimerTask.setTime(time);
		pnoTimerTask.setAppId(appId);
		// created end point - time
		
		time.scheduleAtFixedRate(pnoTimerTask, new Date(), 10*1000); //time);
		
		return appId;
	}

}
