package org.fahai.pattern.factory;

/**   
 * @Title: AbstractHumanFactory.java 
 * @Package org.fahai.pattern.factory 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-23 芟爬02:15:12 
 * @version V1.0   
 */
public abstract class AbstractHumanFactory {

	public abstract IHuman createHuman(Class<? extends IHuman> c);
	
}

