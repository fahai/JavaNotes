package org.fahai.pattern.factory;

/**   
 * @Title: WhiteHuman.java 
 * @Package org.fahai.pattern.factory 
 * @Description: 实现IHuman接口的白种人，可看做是一种产品
 * @author fahai  
 * @date 2014-7-23
 * @version V1.0   
 */
public class WhiteHuman implements IHuman {

	@Override
	public void getColor() {
		System.out.println("White Human");
	}

	@Override
	public void talk() {
		System.out.println("White Human talk something");
	}
	
}

