/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.generic;

import java.util.ArrayList;
import java.util.List;

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
public class GenericList {
	
	private static Logger logger = Logger.getLogger(GenericList.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		List<String> books = new ArrayList<String>();
		books.add("Thinking in Java");
		books.add("Effective Java");
		// books.add(5); // 编译不通过
		logger.info(books);
	}

}
