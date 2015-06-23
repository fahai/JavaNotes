package org.fahai.jikexueyuan.crypt;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception{
//		byte[] myKey = AESUtil.initKey();
//		System.out.println(BytesToHex.fromBytesToHex(myKey));
//		FileOutputStream fos = new FileOutputStream(new File("key.bat"));
//		fos.write(myKey);
//		fos.close();
		
		
//		String pass = "1234567812345678";
		String pass = "fahai31230000000";
		String content = "systemCode=sfcall";
		String encryptText = "9c25dda6848649b8eeee361a8b3c2e7dc78b1bdb29afdd3fc06b1d437344ad9a";
		byte[] key = pass.getBytes();
		System.out.println(Arrays.toString(key));
//		byte[] data = BytesToHex.parseHexStr2Byte(content);
		byte[] data = content.getBytes();
		byte[] resultBytes = AESUtil.encrypt(data, key);
		System.out.println(BytesToHex.fromBytesToHex(resultBytes));
		
		
		byte[] encryptData = BytesToHex.parseHexStr2Byte(encryptText);
		byte[] plainBytes = AESUtil.decrypt(encryptData, key);
		System.out.println(new String(plainBytes));
	}

}
