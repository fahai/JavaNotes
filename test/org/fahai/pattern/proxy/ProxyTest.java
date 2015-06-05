package org.fahai.pattern.proxy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class ProxyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProxyMethod() {
		Source source = new Source();
		Proxy proxy = new Proxy(source);
		proxy.proxyMethod();
	}

}
