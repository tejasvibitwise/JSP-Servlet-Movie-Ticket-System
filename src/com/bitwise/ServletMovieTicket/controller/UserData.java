package com.bitwise.ServletMovieTicket.controller;

import java.util.HashMap;

public class UserData {
	HashMap<String, String> pq = new HashMap<String, String>();

	public UserData() {
		pq.put("tejasvi", "tej");
		pq.put("teju", "tej");

	}

	public boolean returnKeyValue(String key, String value) {
		if (pq.containsKey(key) && pq.containsValue(value))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
	

	}
	
}	