package org.fahai.pattern.command;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class AppTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testApp(){
		String[] args = {};
		App.main(args);
	}

}
