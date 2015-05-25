/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

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
public class TestIterator {
	
	private static final Logger logger = Logger.getLogger(TestIterator.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		
		Collection books = new HashSet();
		books.add("Thinking in Java");
		books.add("Effective Java");
		books.add("JVM");
		books.add("SSH");
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();
			if(book.equals("JVM")){
				// 使用Iteator来迭代访问Collection集合元素时，Collection集合里面的元素不能改变
				// 否则会引发java.util.ConcurrentModificationException
				// books.remove(book); 
				it.remove();
			}
			logger.info("book: " + book);
		}
		
		// JDK 1.5 foreach
		logger.info("JDK 1.5 foreach");
		// 使用foreach迭代访问Collection集合元素时，Collection集合里面的元素不能改变
		for(Object book : books){
			logger.info(book.toString());
		}
		

	}

}
