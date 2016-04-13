package com.test.cgi;

public class MainTestEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(MessageType.PAYMENT.toString());
		System.out.println(MessageType.PAYMENT);
		
		PojoEnum pojo = new PojoEnum();
		pojo.setMessageType(MessageType.PAYMENT);
		
		System.out.println("pojo test:"+pojo.getMessageType());

	}

}
