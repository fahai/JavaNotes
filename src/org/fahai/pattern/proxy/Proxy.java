package org.fahai.pattern.proxy;

/**
 * 描述： 如果已有的方法在使用时需要对原有的方法进行改造
 * 方法一： 修改原有的方法来适应
 * 方法二： 采用一个代理类来调用原有方法，且可对产生的结果进行控制
 * TODO: 跟Decorator模式的区别是什么
 * TODO：　Struts 2 的Filter是不是Proxy模式的应用
 * 
 * @author 449631
 * @since 1.0
 */
public class Proxy implements Sourceable {
	
	private Source source;
	
	public Proxy(Source source){
		super();
		this.source = source;
	}

	@Override
	public void proxyMethod() {
		before();
		source.proxyMethod();
		after();
	}
	
	public void before(){
		log.info("before invoke...");
	}

	public void after(){
		log.info("after invoke...");
	}
	
}
