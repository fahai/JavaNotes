package org.fahai.pattern.visitor;

public class MyVisitor implements Visitor {

	private String name;

	public MyVisitor(String name) {
		this.name = name;
	}

	@Override
	public void visit(Subject subject) {
		log.info(name + " visit subject " + subject.getSubject());
	}

}
