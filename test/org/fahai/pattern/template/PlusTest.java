package org.fahai.pattern.template;

import static org.junit.Assert.*;

import org.fahai.common.LogInterface;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlusTest implements LogInterface {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculate() {
		AbstractCalculator cal = new Plus();
		String exp = "2+8";
		int result = cal.calculate(exp, "\\+");
		log.info(result);
	}

}
