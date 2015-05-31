package org.fahai.thinkinginjava.typeinfo;

import org.apache.log4j.Logger;

public class SweetShop {
	private static Logger logger = Logger.getLogger(SweetShop.class);

	public static void main(String[] args) {
		logger.info("Sweet main method");
		new Candy();
		logger.info("Candy count: " + Candy.count);
		logger.info("After create Candy...");
		try {
			Class.forName("org.fahai.thinkinginjava.typeinfo.Gum");
			logger.info("After create Gum...");
		} catch (ClassNotFoundException e) {
			logger.error("Can not find Gum");
		}
		new Cookies();
	}

}

class Candy{
	public static Integer count = 888;
	static {
		System.out.println("Candy static print");
	}
}

class Gum{
	static {
		System.out.println("Gum static print");
	}
}

class Cookies{
	static {
		System.out.println("Cookies static print");
	}
}
