/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.collection;

import java.util.*;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 20, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class TestList {
	
	private static Logger logger = Logger.getLogger(TestList.class);

	public static void main(String[] args) {
		TestList test = new TestList();
		test.testArrayList();
	}
	
	@SuppressWarnings("unchecked")
	public void testlist(){
		List books = new ArrayList();
		books.add("Effective Java");
		books.add("Thinking in Java");
		books.add("Effective Java");
		books.add("JVM");
		books.add("Thinking in Java");
		books.add("Spring Reference");
		logger.info(books);
		logger.info(books.indexOf("Thinking in Java 4th"));
	}
	
	@SuppressWarnings("unchecked")
	public void testArrayList(){
		ArrayList arrayList = new ArrayList();
		logger.info(arrayList.size());
	}

}
