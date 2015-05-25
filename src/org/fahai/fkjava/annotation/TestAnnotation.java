/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.annotation;

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
public class TestAnnotation {
	
	private static Logger logger = Logger.getLogger(TestAnnotation.class);

	/**
	 * @param args
	 * void
	 */
	@MyAnnotation(name="fahai")
	public static void main(String[] args) {
		TestAnnotation ta = new TestAnnotation();
		logger.info(ta.toString());
	}

}
