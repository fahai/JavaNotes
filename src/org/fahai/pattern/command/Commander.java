package org.fahai.pattern.command;

import org.fahai.common.LogInterface;

/**
 * Command Pattern - 命令模式
 * 司令官下令让士兵干件事情，司令官不会关心士兵如何执行命令，要的就是一个结果
 * 解耦命令的发出者和执行者，实现请求和执行分开
 * 例子：Struts其实就是一种将请求和呈现分离的技术
 * @author fahai
 *
 */
public class Commander implements LogInterface{
	
	private Command command;
	
	public Commander(Command command){
		this.command = command;
	}
	
	public void sendCommand(){
		log.info("Commander send the command...");
		command.execute();
	}

}
