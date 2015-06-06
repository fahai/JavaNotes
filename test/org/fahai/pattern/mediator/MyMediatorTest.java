package org.fahai.pattern.mediator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMediatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWorkAll() {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}

}
