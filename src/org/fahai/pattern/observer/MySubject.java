package org.fahai.pattern.observer;

public class MySubject extends AbstractSubject{

	@Override
	public void operation() {
		log.info("mySubject operation self");
		notifyObservers();
	}
	
}
