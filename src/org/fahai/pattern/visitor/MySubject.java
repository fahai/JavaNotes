package org.fahai.pattern.visitor;

public class MySubject implements Subject {
	
	private String name;
	
	public MySubject(String name){
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return this.name;
	}

}
