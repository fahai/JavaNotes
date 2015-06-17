package org.fahai.jikexueyuan.crypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DESUtil {
	
	// 生成密钥
	public static byte[] initKey(){
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("DES");
			keyGen.init(56);
			SecretKey secretKey = keyGen.generateKey();
			return secretKey.getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 加密
	public static byte[] encrypt(byte[] data, byte[] key){
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		try {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] result = cipher.doFinal(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 解密
	public static byte[] decrypt(byte[] data, byte[] key){
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		try {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] plainByte = cipher.doFinal(data);
			return plainByte;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
