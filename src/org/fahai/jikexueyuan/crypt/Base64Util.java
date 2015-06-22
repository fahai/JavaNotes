package org.fahai.jikexueyuan.crypt;

import java.io.IOException;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class Base64Util {
	
	public static String encryptBase64(byte[] data){
		return new BASE64Encoder().encode(data);
	}
	
	public static String decryptBase64(String data){
		byte[] plainBytes = null;
		try {
			plainBytes = new BASE64Decoder().decodeBuffer(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(plainBytes);
	}
	
	
	/**
	 * JDK
	 * Commons Codec
	 * Bouncy Castle
	 */
	
	/**
	 * telnet stmp.163.com 25
	 * HELO jikexueyuan
	 * AUTH LOGIN
	 * 
	 */

}
