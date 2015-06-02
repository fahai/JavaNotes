package org.fahai.jikexueyuan.thread;

import org.apache.log4j.Logger;

/**
 * 线程的实现方法：继承Thread类 or 实现Runnable接口
 * 线程的常用方法：getName(),currentThread(),isAlive(),sleep(), yield()
 * 优先级
 * 同步与死锁：实现简单的售票程序(资源共享问题)，理解死锁
 * 生命周期：创建， 就绪， 阻塞， 运行， 停止
 * @author fahai
 *
 */
public class Ticket extends Thread{

	private static Logger logger = Logger.getLogger(Ticket.class);
	private String name;
	
	public Ticket(String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		for(int i=0; i<2000; i++){
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
		Ticket t1 = new Ticket(name1);
		Ticket t2 = new Ticket(name2);
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		Ticket t = new Ticket("what");
		t.viewThread("BatMan", "SuperMan");
	}
	
}
