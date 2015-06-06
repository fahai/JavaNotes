package org.fahai.pattern.mediator;

public class UserSecond extends User {

	public UserSecond(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		log.info("Second user work......");
	}

}
