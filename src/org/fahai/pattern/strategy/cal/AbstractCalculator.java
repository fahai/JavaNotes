package org.fahai.pattern.strategy.cal;

/**
 * 描述： Strategy Pattern - 策略模式
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户
 * @author 449631
 * @since 1.0
 */
public abstract class AbstractCalculator {
	
	public int[] split(String exp, String opt){
		String[] array = exp.split(opt);
		int[] arrayInt = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}

}
