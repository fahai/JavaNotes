package org.fahai.pattern.singleton;

/**   
 * @Title: Minister.java 
 * @Package org.fahai.pattern.singleton 
 * @Description: 单例模式的测试类
 * @author fahai  
 * @date 2014-7-23
 * @version V1.0   
 */
public class Minister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int day=1; day<=5; day++){
			Emperor emperor = Emperor.getInstance();
			emperor.say();
		}

	}

}

