package org.fahai.pattern.factory;

/**   
 * @Title: HumanFactory.java 
 * @Package org.fahai.pattern.factory 
 * @Description: 抽象工厂类的子类
 * @author fahai  
 * @date 2014-7-23
 * @version V1.0   
 */
public class HumanFactory extends AbstractHumanFactory {

	@Override
	public IHuman createHuman(Class<? extends IHuman> c) {
		IHuman human = null;
		
		try {
			human = (IHuman)Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("Human race error.");
			e.printStackTrace();
		}
		
		return human;
	}

}

