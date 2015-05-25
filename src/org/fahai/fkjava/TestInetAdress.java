/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class TestInetAdress {

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		InetAddress test;
		try {
			test = InetAddress.getLocalHost();
			System.out.println(test.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
