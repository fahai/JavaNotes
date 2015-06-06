package org.fahai.pattern.state;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContextTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMethod() {
		State state = new State("state1");
		Context context = new Context(state);
		context.method();
		
		context.getState().setValue("state2");
		context.method();
		
		context.getState().setValue("state3");
		context.method();
	}

}
