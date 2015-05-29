/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.fkjava.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
public class TestReflect {
	
	private static Logger logger = Logger.getLogger(TestReflect.class);

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		try {
			Class persion = Class.forName("org.fahai.fkjava.reflect.Persion");
			Persion p = (Persion)persion.newInstance();
			p.info(5);
			Method[] methods = persion.getMethods();
			for(Method method : methods){
				logger.info("method: " + method.toString());
			}
			
			Method method = persion.getMethod("info", String.class);
			method.invoke(persion.newInstance(), "str");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
