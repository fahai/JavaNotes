package org.fahai.pattern.interpreter;

public class Context {

	private int firstNum;
	private int secondNum;
	
	public Context(int firstNum, int secondNum){
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}

	protected int getFirstNum() {
		return firstNum;
	}

	protected void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	protected int getSecondNum() {
		return secondNum;
	}

	protected void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

}
