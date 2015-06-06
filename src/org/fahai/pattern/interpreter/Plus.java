package org.fahai.pattern.interpreter;

public class Plus implements Expression {

	@Override
	public int interpret(Context context) {
		return context.getFirstNum() + context.getSecondNum();
	}

}
