package org.fahai.pattern.observer;

import org.fahai.common.LogInterface;

public interface Subject extends LogInterface{
	
	// add observers
	public void add(Observer observer);
	
	// del observers
	public void del(Observer observer);
	
	// notify all observers
	public void notifyObservers();
	
	// do some operation of myself
	public void operation();
	
}
