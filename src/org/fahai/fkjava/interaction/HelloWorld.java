/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.interaction;

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
public class HelloWorld {
	
	private static Logger logger = Logger.getLogger(HelloWorld.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		logger.info("args length: " + args.length);
		for(String arg : args){
			logger.info(arg);
		}
	}

}
