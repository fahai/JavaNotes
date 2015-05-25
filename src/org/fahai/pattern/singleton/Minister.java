package org.fahai.pattern.singleton;

/**   
 * @Title: Minister.java 
 * @Package org.fahai.pattern.singleton 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-23 芟爬03:31:56 
 * @version V1.0   
 */
public class Minister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int day=1; day<=5; day++){
			Emperor emperor = Emperor.getInstance();
			emperor.say();
		}

	}

}

