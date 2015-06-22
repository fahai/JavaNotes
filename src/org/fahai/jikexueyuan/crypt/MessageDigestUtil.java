package org.fahai.jikexueyuan.crypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MessageDigestUtil {
	
	public static String encryptMD5(byte[] data){
		byte[] resultBytes = null;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(data);
			resultBytes = md5.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String resultString = BytesToHex.fromBytesToHex(resultBytes);
		return resultString;
	}
	
	public static String getMD5OfFile(File file){
		String resultString = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
			byte[] buffer = new byte[1024];
			int read = dis.read(buffer, 0, 1024);
			while(read != -1){
				read = dis.read(buffer, 0, 1024);
			}
			MessageDigest md = dis.getMessageDigest();
			byte[] resultBytes = md.digest();
			resultString = BytesToHex.fromBytesToHex(resultBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	public static String encryptSHA(byte[] data){
		String resultString = null;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(data);
			byte[] resultBytes = sha.digest();
			resultString = BytesToHex.fromBytesToHex(resultBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	
	public static byte[] initHmacKey(){
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
			SecretKey hmacKey = keyGen.generateKey();
			return hmacKey.getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encryptHmac(byte[] data, byte[] key){
		String resultString = null;
		try {
			SecretKey hmacKey = new SecretKeySpec(key, "HmacMd5");
			Mac mac = Mac.getInstance("HmacMd5");
			mac.init(hmacKey);
			byte[] resultBytes = mac.doFinal();
			resultString = BytesToHex.fromBytesToHex(resultBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	
	
	
	

}
