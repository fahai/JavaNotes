package org.fahai.pattern.observer;

public class ObserverFirst implements Observer {

	@Override
	public void update() {
		log.info("first observer has updated!");
	}

}
