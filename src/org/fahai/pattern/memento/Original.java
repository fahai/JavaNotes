package org.fahai.pattern.memento;

import org.fahai.common.LogInterface;

/**
 * Memento Pattern - 备忘录模式 / 备份模式
 * 保存一个对象的某个状态
 * @author fahai
 *
 */
public class Original implements LogInterface {
	
	private String value;
	
	public Original(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public Memento createMemento(){
		return new Memento(value);
	}
	
	public void restoreMemento(Memento memento){
		this.value = memento.getValue();
	}

}
