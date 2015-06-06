package org.fahai.pattern.iterator;

import static org.junit.Assert.*;

import org.fahai.common.LogInterface;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyCollectionTest implements LogInterface{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIterator() {
		Collection myCollection = new MyCollection();
		Iterator myIterator = myCollection.iterator();
		while(myIterator.hasNext()){
			log.info(myIterator.next());
		}
	}

}
