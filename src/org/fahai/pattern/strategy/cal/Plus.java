package org.fahai.pattern.strategy.cal;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class Plus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculator(String exp) {
		int[] arrayInt = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}

}
