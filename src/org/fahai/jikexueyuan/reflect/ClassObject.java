package org.fahai.jikexueyuan.reflect;

import org.apache.log4j.Logger;

public class ClassObject {
	
	private static Logger logger = Logger.getLogger(ClassObject.class);

	/**
	 * 获取Class对象的三种方法
	 * 1. Class.forName()
	 * 2. Object.getClass()
	 * 3. Object.class
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Object ob1 = Class.forName("org.fahai.jikexueyuan.reflect.Book");
			logger.info(ob1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Book ob2 = new Book();
		logger.info(ob2.getClass());
		
		Class ob3 = Book.class;
		logger.info(ob3);
		
		// 使用Class对象实例化对象
		Book book;
		try {
			book = (Book) ob3.newInstance();
			logger.info(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
