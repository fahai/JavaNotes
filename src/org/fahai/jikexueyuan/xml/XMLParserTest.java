package org.fahai.jikexueyuan.xml;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLParserTest {

	@Test
	public void testReadXML() {
		XMLParser parser = new XMLParser();
		parser.readXML("src\\org\\fahai\\jikexueyuan\\xml\\web.xml");
	}

	@Test
	public void testWriteXML() {
		XMLParser parser = new XMLParser();
		parser.writeXML("src\\org\\fahai\\jikexueyuan\\xml\\web.xml", "src\\org\\fahai\\jikexueyuan\\xml\\web_copy.xml");
	}

	@Test
	public void testDom4jReadXML() {
		XMLParser parser = new XMLParser();
		parser.dom4jReadXML();
	}

	@Test
	public void testDom4jWriteXML() {
		XMLParser parser = new XMLParser();
		parser.dom4jWriteXML();
	}

}
