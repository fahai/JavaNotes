package org.fahai.pattern.interpreter;

/**
 * Interpretor Pattern - 解释器模式
 * 一般用于OOP的编译器开发中
 * @author fahai
 *
 */
public interface Expression {
	
	public int interpret(Context context);

}
