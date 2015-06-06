package org.fahai.pattern.mediator;

public class MyMediator implements Mediator {
	
	private User userFirst;
	private User userSecond;

	@Override
	public void createMediator() {
		userFirst = new UserFirst(this);
		userSecond = new UserSecond(this);
	}

	@Override
	public void workAll() {
		userFirst.work();
		userSecond.work();
	}

}
