package org.fahai.jikexueyuan.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * java.lang.reflect.Method
 * 可以操作类的公有，私有方法
 * getName()
 * getReturnType()
 * invoke(Object obj, Object args)
 * getParamType
 * getDeclardAnotion
 * @author fahai
 *
 */
public class MethodTest {
	
	private static Logger logger = Logger.getLogger(MethodTest.class);

	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		mt.showMethods(mt);
		
		Book book = new Book();
		book.setName("Thinking in Java");
		mt.showUse(book);
	}
	
	public void showMethods(Object obj){
		Class clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			logger.info("name: " + method.getName() 
					+ "\t modifier: " + Modifier.toString(method.getModifiers())
					+ "\t returnType: " + method.getReturnType()
					+ "\t argsType: " + Arrays.toString(method.getParameterTypes()));
		}
	}
	
	public void showUse(Object obj){
		Class clazz = obj.getClass();
		try {
			// 无参数的方法调用
			Method method = clazz.getMethod("getName", null);
			method.invoke(obj, null);
			// 单个参数的方法调用
			Method single = clazz.getMethod("setName", String.class);
			single.invoke(obj, "setByInvoke");
			logger.info(obj);
			// 多个参数的方法调用
			Class[] args = {Integer.class, String.class};
			Method multiple = clazz.getMethod("setIdAndName", args);
			Object[] objArgs = {888, "Bynvoke"};
			multiple.invoke(obj, objArgs);
			logger.info(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

}
