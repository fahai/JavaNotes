/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.tmp;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class TestInetAdress {
	
	private static Logger logger = Logger.getLogger(TestInetAdress.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		InetAddress test;
		try {
			test = InetAddress.getLocalHost();
			logger.info(test.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
