package org.fahai.pattern.memento;

import static org.junit.Assert.*;

import org.fahai.common.LogInterface;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OriginalTest implements LogInterface{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateMemento() {
		Original original = new Original("Bat Man");
		// TODO 直接使用Memento不更简单吗
		Storage storage = new Storage(original.createMemento());
		log.info("I am " + original.getValue());
		
		original.setValue("Spider man");
		log.info("Now I am " + original.getValue());
		log.info("restore ing ...");
		original.restoreMemento(storage.getMemento());
		log.info("After restore, I am " + original.getValue());
		
	}

}
