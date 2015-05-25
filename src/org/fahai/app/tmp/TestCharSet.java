/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.tmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 20, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class TestCharSet {

	/**
	 * @param args
	 * void
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\code\\workspace\\JavaNotes\\src\\org\\fahai\\app\\tmp\\TestList.java");  
		InputStream in= new FileInputStream(file);  
		byte[] b = new byte[3];  
		in.read(b);  
		in.close();  
		if (b[0] == -17 && b[1] == -69 && b[2] == -65)  
		    System.out.println(file.getName() + "：编码为UTF-8");  
		else  
		    System.out.println(file.getName() + "：可能是GBK，也可能是其他编码");  
	}

}
