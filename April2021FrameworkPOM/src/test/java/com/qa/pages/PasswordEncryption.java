package com.qa.pages;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncryption {

	public static void main(String[] args) {
		String str = "airtel@123";
		byte[] encode = Base64.encodeBase64(str.getBytes());
		System.out.println("String before encoding is: "+str);
		System.out.println("String after encoding is: "+new String(encode));
		
		byte[] decode = Base64.decodeBase64(encode);
		System.out.println("String after decoding: "+new String(decode));
	}
	

}
