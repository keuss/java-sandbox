package com.test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	public TestHashMap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		
		
		System.out.println("["+map.get(0)+"]");
		
		System.out.println("["+map.get(null)+"]");

	}

}
