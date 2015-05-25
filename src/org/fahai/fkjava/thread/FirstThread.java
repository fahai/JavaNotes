/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.thread;

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
public class FirstThread extends Thread {
	
	private static Logger logger = Logger.getLogger(FirstThread.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			logger.info(Thread.currentThread().getName() + " " + i);
			if(i == 20){
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}
	
	@Override
	public void run(){
		for(int i=0; i<1000; i++){
			logger.info(this.getName() + " " + i);
		}
	}

}
