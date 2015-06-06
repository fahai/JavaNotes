package org.fahai.pattern.observer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySubjectTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOperation() {
		MySubject me = new MySubject();
		ObserverFirst first = new ObserverFirst();
		ObersverSecond second = new ObersverSecond();
		me.add(first);
		me.add(second);
		me.operation();
	}

}
