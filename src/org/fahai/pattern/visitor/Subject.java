package org.fahai.pattern.visitor;

import org.fahai.common.LogInterface;


public interface Subject extends LogInterface{
	
	public void accept(Visitor visitor);
	
	public String getSubject();

}
