package org.fahai.jikexueyuan.json;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JSONParserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadJSON() {
		JSONParser parser = new JSONParser();
		String filename = "src\\org\\fahai\\jikexueyuan\\json\\test.json";
		parser.readJSON(filename);
	}

	@Test
	public void testWriteJSON() {
		JSONParser parser = new JSONParser();
		parser.writeJSON("");
	}

}
