package com.test;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class TestHex {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws DecoderException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
		
		// Apache Commons Codec (TM) software provides implementations of common encoders and decoders such as Base64, Hex, Phonetic and URLs.
		
		
		// ’ vs '
		
		// String -> hex
		
		String charTest = new String(Hex.encodeHex("'".getBytes("UTF-8")));
		System.out.println(charTest); //27
		
		String charTest2 = new String(Hex.encodeHex("’".getBytes("cp1252")));
		System.out.println(charTest2); //92
		
		String charTest3 = new String(Hex.encodeHex("’".getBytes("UTF-8")));
		System.out.println(charTest3); //e28099
		
		//OR
		
		String myString = "'";
		String hexString = Hex.encodeHexString(myString.getBytes("UTF-8"));
		System.out.println(hexString);
		
		// hex -> String
		char[] charArray = { '2', '7'};
		byte [] byteDecode = Hex.decodeHex(charArray);
		System.out.println(new String(byteDecode, "UTF-8"));
		
		char[] charArray2 = { '9', '2'};
		byte [] byteDecode2 = Hex.decodeHex(charArray2);
		System.out.println(new String(byteDecode2, "cp1252"));
		
		char[] charArray3 = { 'e', '2', '8', '0', '9', '9'};
		byte [] byteDecode3 = Hex.decodeHex(charArray3);
		System.out.println(new String(byteDecode3, "UTF-8"));
		
		
		char[] charArray4 = { '9', '2'};
		byte [] byteDecode4 = Hex.decodeHex(charArray4);
		System.out.println(new String(byteDecode4, "UTF-8"));
		
		
		
	}
}
