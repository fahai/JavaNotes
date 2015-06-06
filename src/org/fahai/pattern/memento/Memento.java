package org.fahai.pattern.memento;

public class Memento {
	
	private String value;
	
	public Memento(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(){
		this.value = value;
	}

}
