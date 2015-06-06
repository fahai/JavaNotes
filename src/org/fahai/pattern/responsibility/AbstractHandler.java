package org.fahai.pattern.responsibility;

public abstract class AbstractHandler implements Handler {

	private Handler handler;

	protected Handler getHandler() {
		return handler;
	}

	protected void setHandler(Handler handler) {
		this.handler = handler;
	}

}
