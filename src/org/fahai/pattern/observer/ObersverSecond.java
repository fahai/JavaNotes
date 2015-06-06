package org.fahai.pattern.observer;

public class ObersverSecond implements Observer {

	@Override
	public void update() {
		log.info("second observer has updated!");
	}

}
