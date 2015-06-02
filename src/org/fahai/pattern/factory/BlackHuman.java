package org.fahai.pattern.factory;

/**   
 * @Title: BlackHuman.java 
 * @Package org.fahai.pattern.factory 
 * @Description: 实现IHuman接口的黑种人，可看做是一种产品
 * @author fahai  
 * @date 2014-7-23  
 * @version V1.0   
 */
public class BlackHuman implements IHuman {

	@Override
	public void getColor() {
		System.out.println("Black Human");
	}

	@Override
	public void talk() {
		System.out.println("Black Human talk something");
	}

}

