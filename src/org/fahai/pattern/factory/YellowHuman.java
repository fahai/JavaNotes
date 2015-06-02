package org.fahai.pattern.factory;

/**   
 * @Title: YellowHuman.java 
 * @Package org.fahai.pattern.factory 
 * @Description: 实现IHuman接口的黄种人，可看做是一种产品
 * @author fahai  
 * @date 2014-7-23 
 * @version V1.0   
 */
public class YellowHuman implements IHuman {

	@Override
	public void getColor() {
		System.out.println("Yellow Human");
	}

	@Override
	public void talk() {
		System.out.println("Yellow Human talk something");
	}

}

