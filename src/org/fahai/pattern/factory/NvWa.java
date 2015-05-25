package org.fahai.pattern.factory;

/**   
 * @Title: NvWa.java 
 * @Package org.fahai.pattern.factory 
 * @Description: TODO
 * @author fahai  
 * @date 2014-7-23 下午02:28:44 
 * @version V1.0   
 * @see http://www.cnblogs.com/cbf4life/archive/2009/12/20/1628494.html 
 */
public class NvWa {
	
	public static void main(String[] args){
		
		// 声明阴阳八卦炉
		AbstractHumanFactory YinYangLu = new HumanFactory();
		System.out.println("开炉生火");
		
		System.out.println("create white human");
		IHuman whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();
		
		System.out.println("create yellow human");
		IHuman yellowHuman = YinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
		
		System.out.println("create black human");
		IHuman blackHuman = YinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
		
		System.out.println("关炉熄火");
	}

}

