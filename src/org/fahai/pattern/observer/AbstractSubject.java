package org.fahai.pattern.observer;

import java.util.Vector;

public abstract class AbstractSubject implements Subject {
	
	private Vector<Observer> observers = new Vector<Observer>();

	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void del(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.update();
		}
	}

}
