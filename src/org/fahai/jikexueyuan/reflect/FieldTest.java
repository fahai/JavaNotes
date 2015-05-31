package org.fahai.jikexueyuan.reflect;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

public class FieldTest {
	
	private static Logger logger = Logger.getLogger(FieldTest.class);
	
	/**
	 * java.lang.reflect.Field
	 * getName()
	 * getDeclaredFields() 获取声明的变量，包括私有属性
	 * getFields() 获取声明的变量，只能获取公有属性
	 * setAccessible() 启用/禁用访问权限
	 * @param args
	 */
	public static void main(String[] args) {
		FieldTest test = new FieldTest();
		Field[] fields = Book.class.getFields(); // 只能获取公有属性
		for(Field f : fields){
			logger.info("field name: " + f.getName());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		test.showFields(Book.class);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Book book = new Book();
		book.setId(888);
		book.setName("Thinking in Java");
		book.setType("IT");
		test.showFields(book);
	}
	
	public void showFields(Class clazz){
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields){
			logger.info("field name: " + f.getName() + "\t field type: " + f.getType());
		}
	}
	
	public void showFields(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for(Field f : fields){
				//如果不启用访问属性，会引发IllegalAccessException
				// 这个操作不是将其属性的prinvate改成public
				f.setAccessible(true);  
				logger.info("field name: " + f.getName() + "\t field value: " + f.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
