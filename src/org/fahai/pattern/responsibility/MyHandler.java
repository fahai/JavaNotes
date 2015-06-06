package org.fahai.pattern.responsibility;

/**
 * Chain of Responsibility - 责任链模式
 * 有多个对象，每个对象持有下一个对象的引用，这样形成一条链。
 * 请求在这条链上传递，直到某一对象决定处理该请求。
 * 在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象。
 * @author fahai
 *
 */
public class MyHandler extends AbstractHandler implements Handler {
	
	private String name;
	
	public MyHandler(String name) {
		this.name = name;
	}

	@Override
	public void operator() {
		log.info(name + " handle...");
		if(getHandler() != null){
			getHandler().operator();
		}
	}

}
