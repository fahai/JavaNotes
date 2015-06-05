/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.pattern.decorator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    Jun 5, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class DecoratorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMethod() {
		Source source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.method();
	}

}
