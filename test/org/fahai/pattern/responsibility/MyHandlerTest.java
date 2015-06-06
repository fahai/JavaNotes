package org.fahai.pattern.responsibility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyHandlerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOperator() {
		MyHandler bat = new MyHandler("Bat Man");
		MyHandler spider = new MyHandler("Spider Man");
		MyHandler superMan = new MyHandler("Super Man");
		
		bat.setHandler(spider);
		spider.setHandler(superMan);
		
		bat.operator();
	}

}
