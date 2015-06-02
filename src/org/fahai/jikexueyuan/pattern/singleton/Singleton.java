package org.fahai.jikexueyuan.pattern.singleton;

import org.apache.log4j.Logger;

/**
 * 单例模式的实现原理、类图
 * 多线程优化方案
 * @author fahai
 *
 */
public class Singleton {
	
	private static Logger logger = Logger.getLogger(Singleton.class);
	
	// 唯一的实例对象
	private static Singleton uniqueInstance;
	
	// 私有的构造器
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		logger.info(singleton1.hashCode());
		logger.info(singleton2.hashCode());
	}

}
