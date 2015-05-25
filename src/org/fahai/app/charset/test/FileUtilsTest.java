/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.charset.test;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.fahai.app.charset.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 描述：
 * 
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    May 21, 2015      449631         Create
 * ****************************************************************************
 * </pre>
 * 
 * @author 449631
 * @since 1.0
 */
public class FileUtilsTest {

	private static Logger logger = Logger.getLogger(FileUtilsTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetFiles() {
		FileUtils tool = new FileUtils();
		tool.getFiles(new File(".\\src\\org\\fahai\\app\\charset"));
		File dist = new File("D:\\temp");
		ArrayList<File> files = tool.fileList;
		for (File file : files) {
			logger.info(file.getName());
		}
	}
	
	@Test
	public void testConvertToUTF8(){
		FileUtils tool = new FileUtils();
		String srcPath = ".\\app";
		String distPath = "D:\\temp";
		tool.convertToUTF8(srcPath, distPath);
	}
	
	@Test
	public void testGetFileEncoding(){
		FileUtils tool = new FileUtils();
		File file = new File("d:\\user\\449631\\桌面\\demo.txt");
		logger.info(tool.getFileEncoding(file));
	}

}
