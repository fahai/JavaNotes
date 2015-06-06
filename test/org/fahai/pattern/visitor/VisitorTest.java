package org.fahai.pattern.visitor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VisitorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAccept() {
		Visitor police = new MyVisitor("Police");
		Subject teacher = new MySubject("Teacher");
		
		teacher.accept(police);
	}

}
