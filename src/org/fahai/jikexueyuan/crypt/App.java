package org.fahai.jikexueyuan.crypt;

import java.io.File;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// Base64
		String text = "jikexueyuan";
		byte[] plainBytes = text.getBytes();
		String base64CipherText = Base64Util.encryptBase64(plainBytes);
		System.out.println(text + " >>>Base64 Encode >>> " + base64CipherText);
		String base64PlainText = Base64Util.decryptBase64(base64CipherText);
		System.out.println(base64CipherText + " >>>Base64 Dncode >>> " + base64PlainText);
		
		// MD5
		String md5Result = MessageDigestUtil.encryptMD5(plainBytes);
		System.out.println(text + " >>> MD5 >>> " + md5Result);
		
		// test MD5 of file
		try {
			File file = new File("E:\\workspace\\eclipse\\JavaNotes\\src\\org\\fahai\\jikexueyuan\\crypt\\App.java");
			String md5FileResult = MessageDigestUtil.getMD5OfFile(file);
			System.out.println(file.getName() + " >>> MD5 >>> " + md5FileResult);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		// SHA
		String shaResult = MessageDigestUtil.encryptSHA(plainBytes);
		System.out.println(text + " >>> SHA-1 >>> " + shaResult);
		
		// HMAC
		byte[] hmacKey = MessageDigestUtil.initHmacKey();
		System.out.println("hmacKey: " + BytesToHex.fromBytesToHex(hmacKey));
		String hmacResult = MessageDigestUtil.encryptHmac(plainBytes, hmacKey);
		System.out.println(text + " >>> HMAC >>> " + hmacResult);
		
//		byte[] data = "fahaidashi".getBytes();
//		byte[] keyByte = DESUtil.initKey();
//		System.out.println("source: " + Arrays.toString(data));
//		byte[] cryptByte = DESUtil.encrypt(data, keyByte);
//		System.out.println("encrypt: " + BytesToHex.fromBytesToHex(cryptByte));
//		byte[] plainByte = DESUtil.decrypt(cryptByte, keyByte);
//		System.out.println("decrypt: " + Arrays.toString(plainByte));
	}

}
