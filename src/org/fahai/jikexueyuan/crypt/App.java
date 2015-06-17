package org.fahai.jikexueyuan.crypt;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		byte[] data = "fahaidashi".getBytes();
		byte[] keyByte = DESUtil.initKey();
		System.out.println("source: " + Arrays.toString(data));
		byte[] cryptByte = DESUtil.encrypt(data, keyByte);
		System.out.println("encrypt: " + BytesToHex.fromBytesToHex(cryptByte));
		byte[] plainByte = DESUtil.decrypt(cryptByte, keyByte);
		System.out.println("decrypt: " + Arrays.toString(plainByte));
	}

}
