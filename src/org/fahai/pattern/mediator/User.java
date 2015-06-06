package org.fahai.pattern.mediator;

import org.fahai.common.LogInterface;

public abstract class User implements LogInterface{
	
	private Mediator mediator;
	
	public User(Mediator mediator){
		this.mediator = mediator;
	}
	
	public Mediator getMediator(){
		return mediator;
	}
	
	public abstract void work();

}
