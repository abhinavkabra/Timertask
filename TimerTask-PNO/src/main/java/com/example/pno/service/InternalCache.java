package com.example.pno.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class InternalCache {

	private static Map<String, String> cache = new ConcurrentHashMap<>();
	
	public void add(String key, String value) {
		cache.put(key, value);
	}
	
	public String get(String key) {
		return cache.getOrDefault(key, "Try after sometime");
	}
	
}
