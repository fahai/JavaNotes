package org.fahai.app.test;

import java.util.List;

import org.fahai.app.PrintMapping;
import org.junit.Test;


/**   
 * @Title: PrintMappingTest.java 
 * @Package org.fahai.app.test 
 * @Description: TODO
 * @author fahai  
 * @date 2014-9-16 ÏÂÎç04:41:20 
 * @version V1.0   
 */
public class PrintMappingTest {
	
	PrintMapping pm = new PrintMapping();
	
	@Test
	public void testGetFilename(){
		String directory = "D:\\temp\\src";
		pm.getFilename(directory);
	}
	
	@Test
	public void testGetMappingFromLists(){
		String directory = "D:\\temp\\src";
		List<String> srcfiles = pm.getFilename(directory);
		List<String> result = pm.getMappingFromLists(srcfiles, "13410802579"); 
		for(String str : result){
			System.out.println(str);
		}
	}

}

