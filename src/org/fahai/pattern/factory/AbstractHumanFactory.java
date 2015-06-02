package org.fahai.pattern.factory;

/**   
 * @Title: AbstractHumanFactory.java 
 * @Package org.fahai.pattern.factory 
 * @Description: 抽象工厂类，生产的方法
 * @author fahai  
 * @date 2014-7-23 
 * @version V1.0   
 */
public abstract class AbstractHumanFactory {

	public abstract IHuman createHuman(Class<? extends IHuman> c);
	
}

