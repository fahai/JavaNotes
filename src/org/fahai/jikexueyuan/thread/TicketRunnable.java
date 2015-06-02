/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.jikexueyuan.thread;

import org.apache.log4j.Logger;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    Jun 2, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class TicketRunnable implements Runnable{
	
	private Logger logger = Logger.getLogger(TicketRunnable.class);
	private String name;
	
	public TicketRunnable(String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		for(int i=0; i<10; i++){
			logger.info(name + " : " + i);
		}
	}
	
	/**
	 * 观察两条线程交替执行
	 * @param name1
	 * @param name2
	 * void
	 */
	public void viewThread(String name1, String name2){
		TicketRunnable target1 = new TicketRunnable(name1);
		TicketRunnable target2 = new TicketRunnable(name2);
		Thread spider = new Thread(target1);
		Thread t2 = new Thread(target2);
		logger.info("Thread name: " + spider.getName());
		logger.info("Current thread: " + Thread.currentThread());
		logger.info("isAlive: " + spider.isAlive());
		logger.info("sleep 1 seconds...");
		try {
			spider.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("sleep end...");
		// 提高线程获取资源的优先级
		spider.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		spider.start();
	}
	
	public void saleTickets(){
		// 三个顾客： jetty, tomcat, jboss
		TicketRunnable jetty = new TicketRunnable("jetty");
		TicketRunnable tomcat = new TicketRunnable("tomcat");
		TicketRunnable jboss = new TicketRunnable("jboss");
		Integer tickets = 10;
		
	}
	
	public static void main(String[] args) {
		TicketRunnable tr = new TicketRunnable("");
		tr.viewThread("SpiderManManMan", "IronMan");
	}

}
