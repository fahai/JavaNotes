/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.interaction;

import java.io.IOException;

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
public class TestRuntime {

	private static Logger logger = Logger.getLogger(TestRuntime.class);
	
	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		logger.info("处理器数量： " + rt.availableProcessors());
		logger.info("空闲内存数： " + rt.freeMemory());
		logger.info("总内存数： " + rt.totalMemory());
		logger.info("可用最大内存数： " + rt.maxMemory());
		
		try {
			// run notepad app
			rt.exec("notepad.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
