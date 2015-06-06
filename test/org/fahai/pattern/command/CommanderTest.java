package org.fahai.pattern.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CommanderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSendCommand() {
		Soldier soldier = new Soldier("SuperMan");
		Command command = new MyCommand(soldier);
		Commander commander = new Commander(command);
		commander.sendCommand();
		
	}

}
