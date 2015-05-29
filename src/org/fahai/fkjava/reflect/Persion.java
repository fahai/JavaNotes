/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.reflect;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 26, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class Persion {
	
	private static Logger logger = Logger.getLogger(Persion.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		Persion p = new Persion();
		p.info();
	}
	
	public void info(){
		logger.info("default info method.");
	}
	
	public void info(String content){
		logger.info("info method with String args: " + content);
	}
	
	public void info(Integer num){
		logger.info("info method with Integer args: " + num);
	}
	
	public void info(String content, Integer num){
		logger.info("info method with String and Integer args: " + content + " and " + num);
	}

}
