package org.fahai.pattern.strategy.cal;

import static org.junit.Assert.*;

import org.fahai.common.LogInterface;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class StrategyTest implements LogInterface{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculator() {
		ICalculator cal =  new Plus();
		String exp = "2+8";
		int result = cal.calculator(exp);
		log.info("result: " + result);
		
		cal = new Minus();
		exp = "2-8";
		result = cal.calculator(exp);
		log.info("result: " + result);
	}

}
