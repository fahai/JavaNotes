package org.fahai.pattern.iterator;

public interface Iterator {
	
	public Object previous();
	
	public Object next();
	
	public boolean hasNext();
	
	public Object getFirst();

}
