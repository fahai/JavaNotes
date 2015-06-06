package org.fahai.pattern.mediator;

public class UserFirst extends User {

	public UserFirst(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		log.info("First user work......");
	}

}
