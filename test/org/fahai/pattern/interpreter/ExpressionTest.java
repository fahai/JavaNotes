package org.fahai.pattern.interpreter;

import static org.junit.Assert.*;

import org.fahai.common.LogInterface;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpressionTest implements LogInterface{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInterpret() {
		Context context = new Context(8, 5);
		Expression plus = new Plus();
		Expression minus = new Minus();
		log.info(plus.interpret(context));
		log.info(minus.interpret(context));
	}

}
