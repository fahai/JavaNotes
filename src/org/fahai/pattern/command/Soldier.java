package org.fahai.pattern.command;

import org.fahai.common.LogInterface;

public class Soldier implements LogInterface{
	
	private String name;
	
	public Soldier(String name){
		this.name = name;
	}

	public void action(){
		log.info(name + " receive the command and do action...");
	}
	
}
