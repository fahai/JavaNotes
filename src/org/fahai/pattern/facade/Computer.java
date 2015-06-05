package org.fahai.pattern.facade;

import org.fahai.common.LogInterface;

/**
 * 描述： Facade Pattern - 外观模式
 * 外观模式是为了解决类与类之间的依赖关系
 * 将类之间的关系放到一个Facade类中，降低类之间的耦合度(Spring是类之间的关系放到配置文件中)
 * 如果没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，产生关系，这样会造成严重的依赖，
 * 修改一个类，可能会带来其他类的修改
 * @author 449631
 * @since 1.0
 */
public class Computer implements LogInterface {
	
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer(){
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}
		
	public void startup(){
		String clazzName = this.getClass().getSimpleName();
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info(clazzName + " " + methodName);
		cpu.startup();
		memory.startup();
		disk.startup();
	}
	
	public void shutdown(){
		String clazzName = this.getClass().getSimpleName();
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info(clazzName + " " + methodName);
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
	}

}
