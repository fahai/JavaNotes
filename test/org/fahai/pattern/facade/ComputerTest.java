package org.fahai.pattern.facade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class ComputerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStartup() {
		Computer computer = new Computer();
		computer.startup();
	}

	@Test
	public void testShutdown() {
		Computer computer = new Computer();
		computer.shutdown();
	}

}
