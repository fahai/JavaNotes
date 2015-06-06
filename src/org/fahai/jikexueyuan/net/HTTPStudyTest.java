package org.fahai.jikexueyuan.net;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HTTPStudyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadByGet() {
		HTTPStudy study = new HTTPStudy();
		study.readByGet();
	}

	@Test
	public void testReadByPost() {
		HTTPStudy study = new HTTPStudy();
		study.readByPost();
	}
	
	@Test
	public void testHttpClientbyGet(){
		HTTPStudy study = new HTTPStudy();
		study.httpClientbyGet();
	}
	
	@Test
	public void testHttpClientbyPost(){
		HTTPStudy study = new HTTPStudy();
		study.httpClientbyPost();
	}

}
