/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.pattern.adapter.port;

import static org.junit.Assert.*;

import org.fahai.common.LogInterface;
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
public class AdapterTest implements LogInterface{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFirstMethod() {
		SourceSubFirst first = new SourceSubFirst();
		first.firstMethod();
		first.secondMethod();
		log.info("---------------------");
		SourceSubSecond second = new SourceSubSecond();
		second.firstMethod();
		second.secondMethod();
	}

}
