package org.fahai.pattern.singleton;

/**   
 * @Title: Emperor.java 
 * @Package org.fahai.pattern.singleton 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-23 下午03:28:34 
 * @version V1.0   
 */
public class Emperor {
	
	private static final Emperor emperor = new Emperor();
	
	private Emperor(){
		
	}
	
	public static Emperor getInstance(){
		return emperor;
	}
	
	public static void say(){
		System.out.println("普天之下，莫非王土");
	}

}

