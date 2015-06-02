package org.fahai.jikexueyuan.pattern.command.device;

import org.apache.log4j.Logger;

public class Light {
	
	private static Logger logger = Logger.getLogger(Light.class);
	
	String name = "";
	
	public Light(String name){
		this.name = name;
	}
	
	public void on(){
		logger.info(name + " light on ");
	}
	
	public void off(){
		logger.info(name + " light off ");
	}

}
