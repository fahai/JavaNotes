package org.fahai.pattern.factory;

/**   
 * @Title: HumanFactory.java 
 * @Package org.fahai.pattern.factory 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-23 芟爬02:23:32 
 * @version V1.0   
 */
public class HumanFactory extends AbstractHumanFactory {

	@Override
	public IHuman createHuman(Class<? extends IHuman> c) {
		// TODO Auto-generated method stub
		IHuman human = null;
		
		try {
			human = (IHuman)Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Human race error.");
			e.printStackTrace();
		}
		
		return human;
	}

}

