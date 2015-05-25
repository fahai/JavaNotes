/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.interaction;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 22, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class TestMath {
	
	private static Logger logger = Logger.getLogger(TestMath.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		String ip = "10.85.131.27";
		String[] ips = ip.split(";");
		Random r = new Random();
		for(int i=0; i<5; i++){
			logger.info(ips[r.nextInt(ips.length)]);
		}
	}

}
