package com.cgi.test.test_cxf_spring.client;


public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ClientThread());
		Thread t2 = new Thread(new ClientThread());
		Thread t3 = new Thread(new ClientThread());
		Thread t4 = new Thread(new ClientThread());

		// 4 Threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
