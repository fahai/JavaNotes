package org.fahai.pattern.memento;

public class Storage {
	
	private Memento memento;
	
	public Storage(Memento memento){
		this.memento = memento;
	}

	protected Memento getMemento() {
		return memento;
	}

	protected void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
