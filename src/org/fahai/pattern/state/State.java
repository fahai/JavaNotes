package org.fahai.pattern.state;

import org.fahai.common.LogInterface;

public class State implements LogInterface{
	
	private String value;
	
	public State(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public void method1(){
		log.info("execute state mehtod1");
	}
	
	public void method2(){
		log.info("execute state mehtod2");
	}

}
