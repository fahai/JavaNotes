/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.generic;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 21, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class Apple<E> {

	private static Logger logger = Logger.getLogger(Apple.class);
	private E info;
	
	public Apple(){
		
	}
	
	public Apple(E info){
		this.info = info;
	}
	
	public E getInfo(){
		return this.info;
	}
	
	public void setInfo(E info){
		this.info = info;
	}

	/**
	 * @param args
	 * void
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Apple apple = new Apple();
		// 无法使用setInfo()和getInfo（）方法
		logger.info(apple.info);
		
		Apple str = new Apple<String>();
		str.setInfo("I am a string.");
		logger.info(str.info);
		
		Apple integer = new Apple<Integer>();
		integer.setInfo(5555);
		logger.info(integer.info);
	}
	

}
